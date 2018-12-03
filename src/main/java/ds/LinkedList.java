package ds;

/**
 * This class is a singly linked list.
 */
public class LinkedList {

    private Node head; // The first node in the chain

    /**
     * This inserts a new node at the start of the list, which then links to the prior head node.
     * @param aValue A value to insert.
     */
    public void insert(String aValue) {
        if (aValue == null) {
            System.out.print("Input error: value to insert is null.");
            return;
        }
        head = new Node(aValue, head);
    }

    /**
     * Searches this LinkedList for the specified parameter aValue.
     * @param aValue A value to search for in this LinkedList.
     * @return Indicates if the value is contained in the list.
     */
    public boolean includes(String aValue) {
        Node currentNode = head;
        while (head != null) {
            if (currentNode.getValue().equals(aValue)) {
                return true;
            }
            else {
                currentNode = currentNode.getNextNode();
            }
        }
        return false;
    }

    /**
     * Prints to standard out, the value of all nodes.
     */
    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * Returns the head node.
     * @return The head node. Can be null.
     */
    public Node getFirst() {
        return head;
    }
}
