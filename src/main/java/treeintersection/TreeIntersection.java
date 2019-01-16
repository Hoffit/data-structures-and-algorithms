package treeintersection;

import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;

/**
 * This is a class that can be used to find the intersection of values, in sets of binary trees.
 */
public class TreeIntersection {

    /**
     * Method is used to find common values, if any, in passed in binary tree objects.
     * @param treeOne First tree.
     * @param treeTwo Second tree.
     * @return The list of common values.
     */
    static ArrayList<Integer> treeIntersection(BinaryTree<Integer> treeOne, BinaryTree<Integer> treeTwo) {

        Node<Integer>[] treeOneNodes = treeOne.preOrder();
        Node<Integer>[] treeTwoNodes = treeTwo.preOrder();
        ArrayList<Integer> values = new ArrayList<>(treeOneNodes.length);
        ArrayList<Integer> intersectionValues = new ArrayList<>(Math.min(treeOneNodes.length, treeTwoNodes.length));
        for (int i = 0; i < treeOneNodes.length; i++) {
            values.add(i, treeOneNodes[i].getValue());
        }
        for (int i=0; i < treeTwoNodes.length; i++) {
            if (values.contains(treeTwoNodes[i].getValue()) && !intersectionValues.contains(treeTwoNodes[i].getValue())) {
                intersectionValues.add(treeTwoNodes[i].getValue());
            }
        }
        return intersectionValues;
    }
}
