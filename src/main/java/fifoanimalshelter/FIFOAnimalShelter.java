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

    /**
     * The supported animal types.
     */
    public enum AnimalType {
        CAT, DOG, OTHER
    }

    //TODO Enhancement idea; support generics, and then make these type strict.
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
     * A non-animal specific convenience enqueue operation.
     * @param anAnimal An Animal to add to the shelter queue.
     */
    public void enqueue(Animal anAnimal) {
        AnimalType animalType = AnimalType.OTHER;
        if (anAnimal instanceof Dog) {
            animalType = AnimalType.DOG;
        }
        else if (anAnimal instanceof Cat) {
            animalType = AnimalType.CAT;
        }

        switch (animalType) {
            case CAT:
                enqueue((Cat) anAnimal);
                break;

            case DOG:
                enqueue((Dog) anAnimal);
                break;

            case OTHER:
                shelterOtherQueue.enqueue(anAnimal.getName());
                break;
        }
    }

    /**
     * Inserts a dog at the end of the dog shelter queue.
     * @param aDog
     */
    protected void enqueue(Dog aDog) {
        shelterDogQueue.enqueue(aDog.getName());
    }

    /**
     * Inserts a cat at the end of the cat shelter queue.
     * @param aCat
     */
    protected void enqueue(Cat aCat) {
        shelterDogQueue.enqueue(aCat.getName());
    }

    /**
     * Inserts non-specific types of animals into an 'other' queue.
     * @param anAnimal
     * @return
     */
    public Animal dequeue(Animal anAnimal) {
    }
}
