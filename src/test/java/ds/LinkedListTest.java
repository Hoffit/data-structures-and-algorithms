package ds;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test public void testLinkedListConstructor() {
        LinkedList linkedList = new LinkedList();
        assertNotNull(linkedList);
        assertNull(linkedList.getFirst());
    }

    @Test public void testInsertMethod() {
        LinkedList linkedList = new LinkedList();

        // Test insert null value
        String expected = "Input error: value to insert is null.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.insert(null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Happy path; test insert single non-null value
        String testString = "This is a test!";
        linkedList.insert(testString);
        assertTrue(linkedList.getFirst().getValue().equals(testString));

        // Test inserting five values and check that each is in correct position in the list
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        linkedList = new LinkedList();
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", testString};
        for (int i = elements.length - 1; i >= 0; i--) {
            linkedList.insert(elements[i]);
        }
        // TODO: maybe clean up duplicate code here with loop or helper method
        Node aNode = linkedList.getFirst();
        for (int i = 0; i < elements.length; i++) {
            assertTrue(aNode.getValue().equals(elements[i]));
            aNode = aNode.getNextNode();
        }

        // Lastly; check that last node points to null next node.
        assertNull(aNode);
    }

    @Test public void testIncludesMethod() {
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        LinkedList linkedList = new LinkedList();

        // Test includes when head is null
        assertFalse(linkedList.includes("Should be false"));

        // Test positive outcome of includes when list has just one node
        linkedList.insert(elements[4]);
        assertTrue(linkedList.includes(elements[4]));

        // Test includes when list has five nodes
        for (int i = elements.length - 2; i >= 0; i--) {
            linkedList.insert(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertTrue(linkedList.includes(elements[i]));
        }
    }

    @Test public void testPrintMethod() {
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        LinkedList linkedList = new LinkedList();

        // Print a list with zero nodes (head == null)
        String expected = "";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.print();
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Print a list with one node.
        linkedList.insert(elements[elements.length-1]);
        expected = "This is a test!";
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.print();
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Print a list with five nodes
        for (int i = elements.length - 2; i >= 0; i--) {
            linkedList.insert(elements[i]);
        }
        expected = "First!Second from lastThird from lastFourth from lastThis is a test!";
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.print();
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));
    }

    @Test public void testAppendValueMethod() {
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        LinkedList linkedList = new LinkedList();

        // Add a null value
        String expected = "Input error: value to insert is null.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.appendValue(null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Add a non-null value to a list with one node
        linkedList.insert(elements[2]);
        linkedList.appendValue(elements[3]);
        assertTrue(linkedList.getFirst().getNextNode().getValue().equals(elements[3]));

        // Add non-null value to list with 2+ nodes
        linkedList.appendValue(elements[4]);
        assertTrue(linkedList.getFirst().getNextNode().getNextNode().getValue().equals(elements[4]));

        // Add a non-null value to a list with zero nodes
        linkedList = new LinkedList();
        linkedList.appendValue(elements[0]);
        assertTrue(linkedList.getFirst().getValue().equals(elements[0]));
    }

    @Test public void testInsertBeforeMethod() {
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        LinkedList linkedList = new LinkedList();

        // Add a null value
        String newLine = System.lineSeparator();
        String searchValue = "junk";
        String expected = "Info: No insert before " + searchValue + " because linked list is empty." + newLine;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.insertBefore(searchValue,null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Add a non-null value to a list with one node
        linkedList.insert(elements[4]);
        linkedList.insertBefore(elements[4], elements[3]);
        assertTrue(linkedList.getFirst().getValue().equals(elements[3]));

        // Add non-null value to list with 2+ nodes
        linkedList.insert(elements[2]);
        linkedList.insert(elements[1]);
        linkedList.insertBefore(elements[1], elements[0]);
        assertTrue(linkedList.getFirst().getValue().equals(elements[0]));
    }

    @Test public void testInsertAfterMethod() {
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        LinkedList linkedList = new LinkedList();

        // Add a null value
        String newLine = System.lineSeparator();
        String searchValue = "junk";
        String expected = "Info: No insert after " + searchValue + " because linked list is empty." + newLine;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        linkedList.insertAfter(searchValue,null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));

        // Add a non-null value to a list with one node
        linkedList.insert(elements[2]);
        linkedList.insertAfter(elements[2], elements[4]);
        assertTrue(linkedList.getFirst().getNextNode().getValue().equals(elements[4]));

        // Add non-null value to list with 2+ nodes
        linkedList.insertAfter(elements[2], elements[3]);
        assertTrue(linkedList.getFirst().getNextNode().getValue().equals(elements[3]));
    }
}
