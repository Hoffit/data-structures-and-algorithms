# CF Code Challenge 16
## FizzBuzz.
Conduct FizzBuzz on a tree while traversing through it; Change the value of each
of the nodes, depending on the current node.

## Challenge
### Feature Tasks
Write a function called FizzBuzzTree which takes a tree as an argument.
Without utilizing any of the built-in methods available to your language, determine weather or not the value of each node is divisible by 3, 5 or both, and change the value of each of the nodes:
If the value is divisible by 3, replace the value with “Fizz”
If the value is divisible by 5, replace the value with “Buzz”
If the value is divisible by 3 and 5, replace the value with “FizzBuzz”

Return the tree with its new values.

## Approach & Efficiency
I used the pre-order tree traversal technique to visit each node in the tree, and used modular arithmetic to check for
divisibility by 3 or 5, where the remainder was 0.
- time:   O(n) linear (logn for average case)
- space:  O(1)

## Solution
[White board write up](assets/fizzbuzztree.gif)
