# CF Code Challenge 11: Stacks and Queues
## Stacks and Queues
Implement a Queue using two Stacks.

## Challenge
### Feature Tasks
Create a brand new PseudoQueue class. Do not use an existing Queue. Instead, this PseudoQueue class will implement the standard queue interface, but will internally only utilize 2 Stack objects. Ensure that you create your class with the following methods:

    enqueue(value) which inserts value into the PseudoQueue, using a first-in, first-out approach.
    dequeue() which extracts a value from the PseudoQueue, using a first-in, first-out approach.

The Stack instances have only push, pop, and peek methods. You should use your own Stack implementation. Instantiate these Stack objects in your PseudoQueue constructor.

## Approach & Efficiency
### Two flavors
#### Flavor one
Consecutive enqueue's, or consecutive peeks and dequeue's. But no alternating between them.

Push's, peaks and pops:
- time:   O(1)
- space:  O(1)

#### Flavor two
Alternating enqueue's and peeks or dequeue's.

Push's, peaks and pops:
- time:   O(n)
- space:  O(1)

Explanation: See javadoc and white board image for more details on the algorithm, but anytime there is a switch from operating against one stack, to operating against the
other stack, the contents of the stacks are swapped (Big O(n)). Otherwise, Big O(1).

## API
Please open javadoc on your local computer in your browser:
./javadoc/index.html
./javadoc/queuewithstacks/PseudoQueue.html
./javadoc/queuewithstacks/Queue.html
./javadoc/stacksandqueues/Node.html

## Solution
[White board write up](assets/queue_with_stacks.jpg)