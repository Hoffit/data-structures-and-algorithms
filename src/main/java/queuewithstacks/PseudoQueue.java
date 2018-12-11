package queuewithstacks;

import stacksandqueues.Stack;

/**
 * Stack implementation of a Queue data structure. Utilizes two mutually exclusive stacks;
 * 1. Stack enQueue: it's a backwards queue in that the bottom of the stack represents the front of the queue.
 * 2. Stack deQueue: it's a forwards queue in that the top, where you pop, represents the front of the queue.
 * Mutually exclusive here means that only one of the two can have nodes at a time. What drives which stack
 * has the nodes at any given moment? It depends on the last push, or peek/pop action. If the last action was
 * push, then enQueue has the nodes. If the last action was peek or pop, then the deQueue has the nodes.
 */
public class PseudoQueue implements Queue {

    /**
     * The backwards queue. Contains values when last action was push.
     */
    private final Stack enQueue = new Stack();

    /**
     * The forwards queue. Contains values when last action was peek or pop.
     */
    private final Stack deQueue = new Stack();

    /**
     * Inserts a new value aValue at the back of the queue.
     * @param aValue The value to insert. Must not be null.
     */
    @Override
    public void enqueue(String aValue) {
        //Handle trivial case of empty queues
        if (enQueue.peek() == null && deQueue.peek() == null) {
            enQueue.push(aValue);
            return;
        }

        //Handle case where enqueue has nodes (and not dequeue)
        if (enQueue.peek() != null) {
            enQueue.push(aValue);
            return;
        }

        //Handle case where dequeue has nodes (and not enqueue)
        transferNodesToEnqueueStack();
        enQueue.push(aValue);

    }

    /**
     * Returns the value at the front of the queue, without removing it from the queue.
     * @return The value of the front node in the queue. May be null.
     */
    @Override
    public String peek() {
        //Handle trivial case of empty queues
        if (enQueue.peek() == null && deQueue.peek() == null) {
            return null;
        }

        //Handle case where enqueue has nodes (and not dequeue)
        if (enQueue.peek() != null) {
            transferNodesToDequeueStack();
            return deQueue.peek().getValue();
        }

        //Handle case where dequeue has nodes (and not enqueue)
        if (deQueue.peek() != null) {
            return deQueue.peek().getValue();
        }
        return null;
    }

    /**
     * Returns the value at the front of the queue, and removes it from the queue.
     * @return The value of the front node in the queue. May be null.
     */
    @Override
    public String dequeue() {
        //Handle trivial case of empty queues
        if (enQueue.peek() == null && deQueue.peek() == null) {
            return null;
        }

        //Handle case where enqueue has nodes (and not dequeue)
        if (enQueue.peek() != null) {
            transferNodesToDequeueStack();
            return deQueue.pop().getValue();
        }

        //Handle case where dequeue has nodes (and not enqueue)
        if (deQueue.peek() != null) {
            return deQueue.pop().getValue();
        }
        return null;
    }

    /**
     * Moves nodes from enQueue to deQueue, thereby reversing their order.
     */
    private void transferNodesToDequeueStack() {
        while (enQueue.peek() != null) {
            deQueue.push(enQueue.pop());
        }
    }

    /**
     * Moves nodes from deQueue to enQueue, thereby reversing their order.
     */
    private void transferNodesToEnqueueStack() {
        while (deQueue.peek() != null) {
            enQueue.push(deQueue.pop());
        }
    }
}
