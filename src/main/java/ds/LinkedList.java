package ds;

/**
 * This class is a singly linked list.
 */
public class LinkedList {

    private Node head; // The first node in the chain

    /**
     * Default no-arg constructor.
     */
    public LinkedList() {
        super();
    }

    /**
     * Create a new LinkedList initialized with Nodes for each value in values.
     * The list constructed will maintain the order of the passed in values. So,
     * the first element in the input values will be the first value in the list,
     * and the second element will be the second in the list, and so on.
     * @param values The values for which to create a list of linked Nodes.
     */
    public LinkedList(String[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Error: input values must have at least one value.");
        }
        for (int i = values.length - 1; i >= 0; i--) {
            insert(values[i]);
        }
    }

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

    /**
     * Returns the kth from last Node in this linked list.
     * @param kth The kth from last for which to search.
     * @return The Node that is kth from last. May be null.
     */
    public Node findKthFromLastNode(int kth) {
        if (head == null) {
            System.out.println("Info: No kth from last because linked list is empty.");
            return null;
        }

        int nodeCount = 1; //because head is non-null
        Node currentNode = head;
        Node kthNode = null;
        while (currentNode != null) {
            if (nodeCount > kth) { //if true we will return non-null node.
                kthNode = (kthNode == null) ? (head) : (kthNode.getNextNode());
            }
            nodeCount++;
            currentNode = currentNode.getNextNode();
        }
        return kthNode;
    }

    public static Node merge(LinkedList listOne, LinkedList listTwo) {
        // Check/prevent situations that can't be merged, and would result in a null pointer exception.
        if (listOne == null && listTwo == null) {
            throw new IllegalArgumentException("Both lists to merge are null! Nothing to merge!");
        }
        if ((listOne == null && listTwo.getFirst() == null) || (listTwo == null && listOne.getFirst() == null)) {
            throw new IllegalArgumentException("One list is null and the other has no head! Nothing to merge!");
        }

        // Now check for trivial merges
        if ((listOne == null) || (listOne.getFirst() == null)) {
            return listTwo.getFirst();
        }
        else if ((listTwo == null) || (listTwo.getFirst() == null)) {
            return  listOne.getFirst();
        }

        // TODO Refine while clause for edge cases.
        Node listOneTempHead = listOne.getFirst();
        Node listTwoTempHead = listTwo.getFirst();
        Node listOneNext;
        Node listTwoNext;
        while (listOneTempHead != null && listTwoTempHead != null) {
            // store lists next nodes to we don't loose them
            listOneNext = listOneTempHead.getNextNode();
            listTwoNext = listTwoTempHead.getNextNode();

            // Change the temp heads next nodes (this is the merge action)
            listOneTempHead.setNextNode(listTwoTempHead);
            listTwoTempHead.setNextNode(listOneNext);

            // Update temp list heads for next iteration
            listOneTempHead = listOneNext;
            listTwoTempHead = listTwoNext;

            if (listTwoNext == null) {
                return listOne.getFirst();
            }
            if (listOneNext == null) {
                listOneTempHead.setNextNode(listTwoNext);
            }
        }
        return listOne.getFirst();
    }
}
