# Code Challenge 32 - Intersection of Binary Trees
Find common values in 2 binary trees.

## Challenge
    Write a function called tree_intersection that takes two binary tree parameters.
    Without utilizing any of the built-in library methods available to your language, return a set of values found in both trees.

## Approach and Efficiency
Uses BinaryTree traversal method pre-order, which is Big O(n) time and space, on each input tree.
And, it has an additional two loops.
Net for time is about 4n.
It's also got 4 arrays of about size n. So, space is also 4n.

Big O (n) Time
Big O (n) Space

## Solution
[White board write up](assets/intersection.jpg)
API Docs:
https://hoffit.github.io/data-structures-and-algorithms/
