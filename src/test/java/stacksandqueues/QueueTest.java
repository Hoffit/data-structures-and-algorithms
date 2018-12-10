package stacksandqueues;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testQueueConstructor() {
        Queue queue = new Queue();
        assertNotNull(queue);
        assertNull(queue.peak());
        assertNull(queue.getFront());
        assertNull(queue.getBack());
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueMethod_NullValue() {
        Queue queue = new Queue();

        // Test enqueue null value
        String expected = "Error: invalid input. aValue must be a non-null value.";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        queue.enqueue(null);
        System.setOut(originalOut);
        assertTrue(expected.equals(outContent.toString()));
    }

    @Test
    public void testEnqueueMethod_EmptyString() {
        Queue queue = new Queue();
        queue.enqueue("");
        assertTrue(queue.peak().getValue().equals(""));
    }

    @Test
    public void testEnqueueAndPeakMethods_Simple() {
        Queue queue = new Queue();

        // Happy path; test enqueue single non-null value
        String testString = "This is a test!";
        queue.enqueue(testString);
        assertTrue(queue.peak().getValue().equals(testString));
    }

    @Test
    public void testEnqueueDequeueMethods_Multiple() {
        Queue queue = new Queue();

        // Test inserting five values and check that each is in correct position in the queue
        // "First!" -> "Fourth from last" -> "Third from last" -> "Second from last" -> "This is a test!"
        String[] elements = {"First!", "Second from last", "Third from last", "Fourth from last", "This is a test!"};
        for (int i = elements.length - 1; i >= 0; i--) {
            queue.enqueue(elements[i]);
        }

        Node aNode = queue.dequeue();
        for (int i = elements.length - 1; i >= 0 ; i--) {
            assertTrue(aNode.getValue().equals(elements[i]));
            aNode = queue.dequeue();
        }

        // Lastly; check that last node points to null next node.
        assertNull(aNode);
    }

    @Test
    public void testQueue_Empty() {
        Queue queue = new Queue();
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueMethod_OneElement() {
        Queue queue = new Queue();
        queue.enqueue("I am a lonely node");
        assertTrue(queue.getBack() == queue.getFront());
        assertNull(queue.dequeue().getNextNode());
        assertNull(queue.getFront());
        assertNull(queue.getBack());
    }

    @Test
    public void testEnqueueMethods_TwoElement() {
        Queue queue = new Queue();
        queue.enqueue("I am a lonely node");
        queue.enqueue("Sup lonely node?");
        assertTrue(queue.getBack().getNextNode() == queue.getFront());
        assertNull(queue.getFront().getNextNode());
        assertTrue(queue.getBack().getValue().equals("Sup lonely node?"));
        assertTrue(queue.getFront().getValue().equals("I am a lonely node"));
    }
}
