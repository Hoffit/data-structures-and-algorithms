package stacksandqueues;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStackConstructor() {
        Stack stack = new Stack();
        assertNotNull(stack);
        assertNull(stack.peak());
    }

    @Test
    public void testPushMethod_NullValue() {
        Stack stack = new Stack();

        // Test push null value
        String expected = "Error: the input value to push to the stack is null.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        stack.push(null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));
    }

    @Test
    public void testPushMethod_EmptyString() {
        Stack stack = new Stack();
        stack.push("");
        assertTrue(stack.pop().getValue().equals(""));
    }

    @Test
    public void testPushAndPeakMethods_Simple() {
        Stack stack = new Stack();

        // Happy path; test push single non-null value
        String testString = "This is a test!";
        stack.push(testString);
        assertTrue(stack.peak().getValue().equals(testString));
    }

    @Test
    public void testPushPopMethods_Multiple() {
        Stack stack = new Stack();

        // Test inserting five values and check that each is in correct position in the list
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        for (int i = elements.length - 1; i >= 0; i--) {
            stack.push(elements[i]);
        }

        Node aNode = stack.pop();
        for (int i = 0; i < elements.length; i++) {
            assertTrue(aNode.getValue().equals(elements[i]));
            aNode = aNode.getNextNode();
        }

        // Lastly; check that last node points to null next node.
        assertNull(aNode);
    }

    @Test
    public void testPopMethod_Empty() {
        Stack stack = new Stack();
        assertNull(stack.pop());
    }
}
