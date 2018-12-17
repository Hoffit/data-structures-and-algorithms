package tree;

import java.util.ArrayList;

public class BinaryTree {

    public static ArrayList<Node> preOrder(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList returnList = null;
        ArrayList leftTraversal = preOrder(node.getLeftChildNode());
        ArrayList rightTraversal = preOrder(node.getRightChildNode());
        if (leftTraversal == null && rightTraversal == null) {
            returnList = new ArrayList<Node>();
            returnList.add(node);
        }
        return returnList;
    }

    public Node[] inOrder(Node rootNode) {
        //TODO
        return null;
    }

    public Node[] postOrder(Node rootNode) {
        //TODO
        return null;
    }
}
