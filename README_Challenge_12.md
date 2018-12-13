# CF Code Challenge 12: Stacks and Queues
## Stacks and Queues
First-in, First out Animal Shelter.

## Challenge
### Feature Tasks

Create a class called AnimalShelter which holds only dogs and cats. The shelter operates using a first-in, first-out approach.

Implement the following methods:
- enqueue(animal): adds animal to the shelter. animal can be either a dog or a cat object.
- dequeue(pref): returns either a dog or a cat. If pref is not "dog" or "cat" then return null.

## Approach & Efficiency
This is a three queue based solution.
Queue One: cats
Queue Two: dogs
Queue Three: animals.

The system model consists of three concrete classes: Animal, Cat, Dog.
Cat and Dog are subclasses of Animal.

Depending on the class, new animals are placed in or retrieved from the appropriate queue.

Limitation: Because this lab re-uses work from previous labs, the constraint of nodes containing a String object remains.
Otherwise, a good deal of re-factoring would be required to support Animal objects in nodes.

Enqueues and peeks, and dequeue's:
- time:   O(1)
- space:  O(1)

See javadoc and white board image for more details.

## API
Please open javadoc on your local computer in your browser:
./javadoc/index.html
./javadoc/fifoanimalshelter/FIFOAnimalShelter.html

## Solution
[White board write up](assets/fifo_animal_shelter.jpg)