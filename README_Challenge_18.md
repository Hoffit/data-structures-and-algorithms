# CF Code Challenge 18
## BinaryTree Search for Maximum Value
Extend prior lab BinaryTree implementation with a new search method, findMaximumValue.

## Challenge
### Feature Tasks
Write a function called find-maximum-value which takes binary tree as its only input.
Without utilizing any of the built-in methods available to your language, return the maximum value stored in the tree. You can assume that the values stored in the Binary Tree will be numeric.

## Approach & Efficiency
This uses the now-familiar recursive pre-order type algorithm to traverse the tree.
At each node, there is logic to compare the three nodes available at that point;
1. the current/root node
2. the left child node
3. the right child node

Whichever is greatest, is returned to the caller.
It favors root, and left nodes, when there is a tie.

- time:   O(n)
- space:  O(1)

### Testing
Testing is done in the existing class, BinaryTreeTest which added a new test method: testFindMaxValueMethod()

## Solution
[White board write up](assets/find-maximum-value-binary-tree.gif)
