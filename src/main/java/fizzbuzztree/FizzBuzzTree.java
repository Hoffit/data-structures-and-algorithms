package fizzbuzztree;

import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;

public class FizzBuzzTree {

    static void fizzBizzTree(BinaryTree tree) {
        if (tree == null || tree.getRoot() == null || tree.getRoot().getValue() == null) {
            return;
        }
        fizzBizzTree(tree.getRoot());
    }

    private static void fizzBizzTree(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        int intValue = ((Integer) rootNode.getValue());
        if (intValue % 3 == 0) {
            if (intValue % 5 == 0) {
                rootNode.setValue("FizzBuzz");
            }
            else {
                rootNode.setValue("Fizz");
            }
        }
        else if (intValue % 5 == 0) {
            rootNode.setValue("Buzz");
        }
        fizzBizzTree(rootNode.getLeftChildNode());
        fizzBizzTree(rootNode.getRightChildNode());
    }
}
