# Trees
This lab implements a BinaryTree and BinarySearchTree class, with various methods in each.

## Challenge
### Features
Create a Node class that has properties for the value stored in the node, the left child node, and the right child node.
Create a BinaryTree class
   Define a method for each of the depth first traversals called preOrder, inOrder, and postOrder which returns an array of the values, ordered appropriately.

At no time should an exception or stack trace be shown to the end user. Catch and handle any such exceptions and return a printed value or operation which cleanly represents the state and either stops execution cleanly, or provides the user with clear direction and output.

Create a BinarySearchTree class
   Define a method named add that accepts a value, and adds a new node with that value in the correct location in the binary search tree.
   Define a method named contains that accepts a value, and returns a boolean indicating whether or not the value is in the tree at least once.

## Approach and Efficiency
### BinaryTree with traversal methods pre-order, in-order, post-order.
The approach I took was inspired by this wiki page: https://en.wikipedia.org/wiki/Tree_traversal
It lays out so nicely the traversals pre-order, in-order, and post-order.
Big O (n) Time
Big O (n) Space

### BinarySearchTree with methods add and search.
The approach I took was based on the tree-traversal algorithms above.
This is a great wiki page on performance: https://en.wikipedia.org/wiki/Binary_search_tree
Big O (n) Time
Big O (n) Space
It includes that the average performance is much better than linear (aka Big O(n)). It's Big O(logn).

## API See the javadoc for details.
/javadoc/
