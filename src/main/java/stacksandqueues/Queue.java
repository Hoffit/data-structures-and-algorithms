package stacksandqueues;

/**
 * This is a queue data structure implementation.
 */
public class Queue {

    /**
     * The front node in the queue.
     */
    private Node front;

    /**
     * The back node in the queue.
     */
    private Node back;

    /**
     * Inserts a new node at the back of the queue, with value aValue.
     * @param aValue The value to insert at the back of the queue. Must be non-null.
     */
    public void enqueue(String aValue) {
        if (aValue == null) {
            System.out.print("Error: invalid input. aValue must be a non-null value.");
            return;
        }

        // Handle empty queue scenario
        if (front == null) {
            front = new Node(aValue, null);
            back = front;
            return;
        }

        // Handle non-empty queue scenario
        back = new Node(aValue, back);
    }

    /**
     * Returns the node at the front of the queue, and removes it from the queue.
     * @return The node at the front of the queue. May be null.
     */
    public Node dequeue() {
        // if queue is empty, just return null
        if (front == null) {
            return null;
        }

        // if just one node in queue, return front and set both to null
        if (front == back) {
            Node returnNode = front;
            front = null;
            back = null;
            return returnNode;
        }

        // everything else
        Node currentNode = back;
        Node returnNode;
        while (currentNode != null) {
            if (currentNode.getNextNode() == front) {
                returnNode = front;
                currentNode.setNextNode(null);
                front = currentNode;
                return  returnNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    /**
     * Returns the node at the front of the queue, without removing it from the queue.
     * @return The node at the front of the queue. May be null.
     */
    public Node peak() {
        return front;
    }

    /**
     * Returns the front node in the queue. Intended as a helper method for testing.
     * @return The front node in the queue.
     */
    Node getFront() {
        return front;
    }

    /**
     * Returns the back node in the queue. Intended as a helper method for testing.
     * @return The back node in the queue.
     */
    Node getBack() {
        return back;
    }
}
