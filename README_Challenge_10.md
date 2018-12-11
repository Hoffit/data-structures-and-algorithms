# CF Lab 10: Stacks and Queues
## Stacks and Queues
Implement a Stack and a Queue Data Structure.

## Challenge
### Feature Tasks
Create a Node class that has properties for the value stored in the Node, and a pointer to the next node

Create a Stack class that has a top property. It creates an empty Stack when instantiated.
        This object should be aware of a default empty value assigned to top when the stack is created.
        Define a method called push which takes any value as an argument and adds a new node with that value to the top of the stack with an O(1) Time performance.
        Define a method called pop that does not take any argument, removes the node from the top of the stack, and returns the node.
        Define a method called peek that does not take an argument and returns the node located on the top of the stack.

Create a Queue class that has a top property. It creates an empty queue when instantiated.
        This object should be aware of a default empty value assigned to front when the queue is created.
        Define a method called enqueue which takes any value as an argument and adds a new node with that value to the back of the queue with an O(1) Time performance.
        Define a method called dequeue that does not take any argument, removes the node from the front of the queue, and returns the node.
        Define a method called peek that does not take an argument and returns the node located in the front of the stack.

At no time should an exception or stack trace be shown to the end user. Catch and handle any such exceptions and return a printed value or operation which cleanly represents the state and either stops execution cleanly, or provides the user with clear direction and output.

Be sure to follow your languages best practices for naming conventions.

## Approach & Efficiency
Stack push's, peeks and pops:
- time:   O(1)
- space:  O(1)

Queue enqueues, and peeks:
- time:   O(1)
- space:  O(1)

Queue dequeue's:
- time:   O(n)
- space:  O(1)

## API
Please open javadoc on your local computer in your browser:
./javadoc/index.html
./javadoc/stacksandqueues/Stack.html
./javadoc/stacksandqueues/Queue.html
./javadoc/stacksandqueues/Node.html
