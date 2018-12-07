# CF Code Challenge 07
## k-th value from the end of a linked list.
Prior labs had us build LinkedList with Nodes. This challenge has us expand it a bit with one.

## Challenge
### Feature Tasks

Write a method for the Linked List class which takes a number, k, as a parameter. Return the node�s value that is k from the end of the linked list. You have access to the Node class and all the properties on the Linked List class as well as the methods created in previous challenges.

## Approach & Efficiency
See the white board images. In a nutshell; walk the list and keep track of list.length - kth node until the end is reached, and then return value.
### Big O
time    Big O(n) => Linear
space   Big O(1) => Constant

## Solution for method .append(value)
[White board write up](assets/ll_kth_from_end.jpg)
