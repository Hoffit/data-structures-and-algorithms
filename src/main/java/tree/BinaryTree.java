package tree;

import java.util.ArrayList;

public class BinaryTree {

    public static ArrayList<Node> preOrder(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> returnList = new ArrayList<Node>();
        returnList.add(node);
        ArrayList<Node> leftTraversal = preOrder(node.getLeftChildNode());
        ArrayList<Node> rightTraversal = preOrder(node.getRightChildNode());
        if (leftTraversal == null && rightTraversal == null) {
            returnList.add(node);
            return returnList;
        }
        if (leftTraversal != null && rightTraversal != null) {
            returnList.addAll(leftTraversal);
            returnList.addAll(rightTraversal);
            return returnList;
        }
        if (leftTraversal == null) {
            return rightTraversal;
        }
        return leftTraversal;
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
