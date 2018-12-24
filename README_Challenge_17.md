# CF Code Challenge 17
## BinaryTree Breadth First Search
Extend prior lab BinaryTree implementation.

## Challenge
### Feature Tasks
Write a breadth first traversal method which takes a Binary Tree as its unique input. Without
utilizing any of the built-in methods available to your language, traverse the input tree using
a Breadth-first approach; print every visited node’s value.

## Approach & Efficiency
I added to the previous lab/challenge class BinaryTree by adding a method breadthFirst().
For testing, same deal - extended the class BinaryTreeTest by adding method testBreadthFirstTraversalMethod().

My solution was inspired by this sites overview of the breadth first concept:
https://www.cs.bu.edu/teaching/c/tree/breadth-first/
I highly recommend it; really clear read.

Unlike all the depth first tree traversal algorithms done so far, this was does not use recursion.
It is iterative.

The key observation outlined in that linked site, but also mentioned in lecture, is that a 
queue data structure is ideal for this type of traversal.

The algorithm uses Java's LinkedList queue implementation for node visits.

Big O:
- time:   O(n)
- space:  O(n) 

## Solution
[White board write up](assets/breadth-first-traversal.gif)
