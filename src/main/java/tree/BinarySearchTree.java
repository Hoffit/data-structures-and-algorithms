package tree;

/**
 * This is a binary search tree data structure.
 */
class BinarySearchTree {

    /**
     * The root node in the binary search tree.
     */
    private Node root;

    /**
     * Constructor.
     * @param root The root node of the tree. Must not be null and must have a non-null value.
     */
    BinarySearchTree(Node root) {
        if (root == null || root.getValue() == null) {
            throw new IllegalArgumentException("Error: can't create a BinarySearchTree without a root!");
        }
        this.root = root;
    }

    void addNode(Node node) {
        addNode(root, node);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private static void addNode(Node root, Node node) {
        if (node.compareTo(root) == 0) {
            return;
        }
        if (node.compareTo(root) < 0) {
            if (root.getLeftChildNode() == null) {
                root.setLeftChildNode(node);
                return;
            }
            addNode(root.getLeftChildNode(), node);
        }
        if (node.compareTo(root) > 0) {
            if (root.getRightChildNode() == null) {
                root.setRightChildNode(node);
                return;
            }
            addNode(root.getRightChildNode(), node);
        }
    }

    public Node search(Node T) {
        return search(root, T);
    }

    private static Node search(Node root, Node T) {
        if (root == null) {
            return null;
        }
        if (T.compareTo(root) == 0) {
            return root;
        }
        if (T.compareTo(root) < 0) {
            return search(root.getLeftChildNode(), T);
        }
        if (T.compareTo(root) > 0) {
            return search(root.getRightChildNode(), T);
        }
        return null;
    }
}
