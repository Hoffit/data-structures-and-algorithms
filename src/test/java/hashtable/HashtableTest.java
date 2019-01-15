package hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class HashtableTest {

    //Properties for the base happy path valid hashtable with no collisions
    private String[] inputKeys = new String[] {
            "This",
            "is",
            "a",
            "set",
            "of",
            "keys"
    };
    private Integer[] inputValues = new Integer[] {
            99,
            44,
            888,
            1,
            44444,
            9999999
    };
    private int[] expectedKeys = {
            408,
            220,
            97,
            332,
            213,
            444
    };

    //Properties for the base path valid hashtable WITH collisions
    private String[] inputKeysWithCollisions = new String[] {
            "Collide!",
            "Cokmide!",
            "ok",
            "Collicf!"
    };
    private Integer[] inputValuesWithCollisions = new Integer[] {
            42,
            88,
            66,
            9999
    };
    private int[] expectedKeysForWithCollisions = {
            733,
            218
    };

    //Hashtable constructor tests
    @Test
    public void testHashtableConstructor() {
        Hashtable hashtable = new Hashtable();
        assertNotNull(hashtable);
    }

    // Add tests
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithException() {
        Hashtable hashtable = new Hashtable();
        hashtable.add(null, "test me");
    }

    @Test
    public void testAddMethod() {
        //Setup the test scenario.
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();

        //Now - test that the keys and values created within the Hashtable are correct.
        ArrayList outputKeys = hashtable.getKeys();
        for (int i = 0; i < inputKeys.length; i++) {
            assertTrue(outputKeys.get(i).equals(expectedKeys[i]));
        }
        ArrayList<LinkedList> outputValues = hashtable.getValues();
        for (int i = 0; i < inputValues.length; i++) {
            String outputKey = (String)outputValues.get(i).getFirst();
            Integer outputValue = (Integer)outputValues.get(i).getLast();
            assertTrue(inputKeys[i].equals(outputKey));
            assertTrue(inputValues[i] == outputValue);
        }
    }

    @Test
    public void testAddMethodWithCollisions() {
        //Setup the test scenario.
        Hashtable hashtable = makeBaseValidHashtableWithCollisions();

        //Now - test that the keys and values created within the Hashtable are correct.
        ArrayList outputKeys = hashtable.getKeys();
        assertTrue(outputKeys.size() == 2);
        for (int i = 0; i < outputKeys.size(); i++) {
            assertTrue((int)outputKeys.get(i) == expectedKeysForWithCollisions[i]);
        }
        ArrayList<LinkedList> outputValues = hashtable.getValues();
        assertTrue(outputValues.size() == 2);
        LinkedList bucket1 = outputValues.get(0);
        assertTrue(bucket1.size() == 6);
    }

    // find tests
    @Test(expected = IllegalArgumentException.class)
    public void testFindWithException() {
        Hashtable hashtable = new Hashtable();
        hashtable.find(null);
    }

    @Test
    public void testFindInEmpty() {
        Hashtable hashtable = new Hashtable();
        assertNull(hashtable.find("Mary had a little lamb"));
    }

    @Test
    public void testFindNotFound() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        assertNull(hashtable.find("ZZZZZZZZZZZ"));
    }

    @Test
    public void testFindWithCollisionNotFound() {
        Hashtable hashtable = makeBaseValidHashtableWithCollisions();
        assertNull(hashtable.find("ZZZZZZZZZZZ"));
    }

    @Test
    public void testFindMethodNoCollisions() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        for (int i = 0; i < inputKeys.length; i++) {
            assertTrue(hashtable.find(inputKeys[i]) == inputValues[i]);
        }
    }

    @Test
    public void testFindMethodWithCollisions() {
        Hashtable hashtable = makeBaseValidHashtableWithCollisions();
        for (int i = 0; i < inputKeysWithCollisions.length; i++) {
            assertTrue(hashtable.find(inputKeysWithCollisions[i]) == inputValuesWithCollisions[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsMethodWithException() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        hashtable.contains(null);
    }

    @Test
    public void testContainsMethodAffirmative() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        assertTrue(hashtable.contains("is"));
    }

    @Test
    public void testContainsMethodNegative() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        assertTrue(!hashtable.contains("that'd be a no"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHashMethodWithException() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        hashtable.contains(null);
    }

    @Test
    public void testGetHashMethodNotFound() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        assertEquals(hashtable.getHash("It's not here!"), -1);
    }

    @Test
    public void testGetHashMethodIsFound() {
        Hashtable hashtable = makeBaseValidHashtableNoCollisions();
        for (int i = 0; i < inputKeys.length; i++) {
            assertEquals(hashtable.getHash(inputKeys[i]), i);
        }
    }

    private Hashtable makeBaseValidHashtableNoCollisions() {
        //Setup the test scenario.
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < inputKeys.length; i++) {
            hashtable.add(inputKeys[i], inputValues[i]);
        }
        return hashtable;
    }

    private Hashtable makeBaseValidHashtableWithCollisions() {
        //Setup the test scenario.
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < inputKeysWithCollisions.length; i++) {
            hashtable.add(inputKeysWithCollisions[i], inputValuesWithCollisions[i]);
        }
        return hashtable;
    }
}
