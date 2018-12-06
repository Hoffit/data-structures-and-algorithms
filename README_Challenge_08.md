# CF Code Challenge 08
## Merge two linked lists.
Prior labs had us build LinkedList with Nodes. This challenge has us expand it a bit with one new method.

## Challenge
### Feature Tasks

Write a function called mergeLists which takes two linked lists as arguments. Zip the two linked lists together into one so that the nodes alternate between the two lists and return a reference to the head of the zipped list. Try and keep additional space down to O(1). You have access to the Node class and all the properties on the Linked List class as well as the methods created in previous challenges.

## Approach & Efficiency
See the white board images. In a nutshell; observe that what your doing is tracking two list heads, and two list next nodes. Modify the heads next in a zip fashion, update loop parms, and go again.
It's constant time and space. Very efficient. But there are so many edge cases to account for , that the code becomes overly complex.

## Solution for method Node merge(LinkedList listOne, LinkedList listTwo)
[White board write up](assets/ll_merge.jpg)
