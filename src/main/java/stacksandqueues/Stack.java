package stacksandqueues;

/**
 * This is a stack data structure implementation.
 */
public class Stack {

    /**
     * The top node in the stack.
     */
    private Node top;

    /**
     * Inserts a new node at the top of the stack, with value aValue.
     * @param aValue The value to insert onto the stack. Must be non-null.
     */
    public void push(String aValue) {
        if (aValue == null) {
            System.out.println("Error: the input value to push to the stack is null.");
            return;
        }
        top = new Node(aValue, top);
    }

    /**
     * Returns the node at the top of the stack.
     * @return The top node in the stack. May be null.
     */
    public Node pop() {
        if (top != null) {
            Node tempNode = top;
            top = top.getNextNode();
            return tempNode;
        }
        return null;
    }

    /**
     * Returns the top node in the stack, without removing it from the stack.
     * @return The Node at the top of the stack. May be null.
     */
    public Node peak() {
        return top;
    }
}
