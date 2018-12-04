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

    /**
     * Appends a new node with aValue to the end of this linked list.
     * @param aValue The value for the new node.
     */
    public void appendValue(String aValue) {
        if (aValue == null) {
            System.out.print("Input error: value to insert is null.");
            return;
        }

        if (head == null) {
            insert(aValue);
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getNextNode() == null) {
                currentNode.setNextNode(new Node(aValue, null));
                return;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * Inserts a new Node into this linked list prior to the first node with value aValue.
     * If the searchValue is never found, exits without insertion.
     * @param searchValue The Node for for which to search.
     * @param aValue The value to insert.
     */
    public void insertBefore(String searchValue, String aValue) {
        if (head == null) {
            System.out.println("Info: No insert before " + searchValue + " because linked list is empty.");
            return;
        }
        else if (head.getValue().equals(searchValue)) {
            insert(aValue);
            return;
        }
        else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                if (currentNode.getValue().equals(searchValue)) { //found
                    currentNode.setNextNode(new Node(aValue, currentNode.getNextNode()));
                    return;
                }
                currentNode = currentNode.getNextNode();
            }
        }
    }

    /**
     * Inserts a new Node into this linked list after the first node with value aValue.
     * If the searchValue is never found, exits without insertion.
     * @param searchValue The Node for for which to search.
     * @param aValue The value to insert.
     */
    public void insertAfter(String searchValue, String aValue) {
        if (head == null) {
            System.out.println("Info: No insert after " + searchValue + " because linked list is empty.");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(searchValue)) {
                currentNode.setNextNode(new Node(aValue, currentNode.getNextNode()));
                return;
            }
            currentNode = currentNode.getNextNode();
        }
    }
}
