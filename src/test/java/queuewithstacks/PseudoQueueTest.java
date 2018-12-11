package queuewithstacks;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PseudoQueueTest {

    @Test
    public void testPseudoQueueConstructor() {
        PseudoQueue queue = new PseudoQueue();
        assertNotNull(queue);
        assertNull(queue.peek());
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueMethod_NullValue() {
        PseudoQueue queue = new PseudoQueue();

        // Test enqueue null value
        String expected = "Error: the input value to push to the stack is null.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        queue.enqueue(null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));
    }

    @Test
    public void testEnqueueMethod_EmptyString() {
        PseudoQueue queue = new PseudoQueue();
        queue.enqueue("");
        assertTrue(queue.peek().equals(""));
    }

    @Test
    public void testEnqueueAndpeekMethods_Simple() {
        PseudoQueue queue = new PseudoQueue();

        // Happy path; test enqueue single non-null value
        String testString = "This is a test!";
        queue.enqueue(testString);
        assertTrue(queue.peek().equals(testString));
    }

    @Test
    public void testEnqueueDequeueMethods_Multiple() {
        PseudoQueue queue = new PseudoQueue();

        // Test inserting five values and check that each is in correct position in the queue
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        for (int i = elements.length - 1; i >= 0; i--) {
            queue.enqueue(elements[i]);
        }

        String aNodeValue = queue.dequeue();
        for (int i = elements.length - 1; i >= 0 ; i--) {
            assertTrue(aNodeValue.equals(elements[i]));
            aNodeValue = queue.dequeue();
        }

        // Lastly; check that last node points to null next node.
        assertNull(aNodeValue);
    }

    @Test
    public void testPseudoQueue_Empty() {
        PseudoQueue queue = new PseudoQueue();
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueMethod_OneElement() {
        PseudoQueue queue = new PseudoQueue();
        queue.enqueue("I am a lonely node");
        assertTrue(queue.dequeue().equals("I am a lonely node"));
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueMethods_TwoElement() {
        PseudoQueue queue = new PseudoQueue();
        queue.enqueue("I am a lonely node");
        queue.enqueue("Sup lonely node?");
        String lonelyNode = queue.dequeue();
        String friend = queue.dequeue();
        assertTrue(friend.equals("Sup lonely node?"));
        assertTrue(lonelyNode.equals("I am a lonely node"));
    }
}
