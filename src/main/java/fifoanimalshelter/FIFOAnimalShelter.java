package fifoanimalshelter;

import stacksandqueues.Queue;

/**
 * This is a queue based (FIFO) data structure whose nodes are animal names.
 * The standard queue operations of enqueue and dequeue are supported.
 * Except, they work with animal arguments.
 *
 * It doesn't support generics, and is a learning based implementation
 * that only stores the name of an animal, not the animal object itself.
 */
public class FIFOAnimalShelter {

    //TODO Enhancement idea; support generics, and then make these type strict.
    //It's a big multi-lab refactor which is why I'm not touching it right now.
    /**
     * The dog queue
     */
    private final Queue shelterDogQueue = new Queue();

    /**
     * The cat queue
     */
    private final Queue shelterCatQueue = new Queue();

    /**
     * The 'other' queue
     */
    private final Queue shelterOtherQueue = new Queue();

    /**
     * Inserts a dog at the end of the dog shelter queue.
     * @param aDog A dog to add to the queue.
     */
    public void enqueue(Dog aDog) {
        shelterDogQueue.enqueue(aDog.getName());
    }

    /**
     * Inserts a cat at the end of the cat shelter queue.
     * @param aCat A cat to add to the queue.
     */
    public void enqueue(Cat aCat) {
        shelterCatQueue.enqueue(aCat.getName());
    }

    /**
     * Inserts an animal at the end of the animal shelter queue.
     * @param anAnimal An animal to add to the animal queue.
     */
    public void enqueue(Animal anAnimal) {
        shelterOtherQueue.enqueue(anAnimal.getName());
    }

    /**
     * Returns an animal of the specified type, typeOfAnimal, if there is one in the queue.
     * @param typeOfAnimal The type of animal to return. Must be Animal.class, or one of its subclasses.
     * @return An animal of the requested type.
     */
    public Animal dequeue(Class typeOfAnimal) {
        if (typeOfAnimal == Dog.class) {
            if (shelterDogQueue.peek() != null) {
                return new Dog(shelterDogQueue.dequeue().getValue());
            }
            else {
                return null;
            }
        }
        if (typeOfAnimal == Cat.class) {
            if (shelterCatQueue.peek() != null) {
            return new Cat(shelterCatQueue.dequeue().getValue());
        }
        else {
            return null;
        }
        }
        if (typeOfAnimal == Animal.class) {
            if (shelterOtherQueue.peek() != null) {
            return new Animal(shelterOtherQueue.dequeue().getValue());
    }
            else {
        return null;
    }
        }
        return null;
    }
}
