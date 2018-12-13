package fifoanimalshelter;


import org.junit.Test;

import static org.junit.Assert.*;

public class FIFOAnimalShelterTest {

    @Test
    public void testAnimals() {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Animal animal = new Animal();

        assertTrue(cat.getName()==null);
        assertTrue(dog.getName()==null);
        assertTrue(animal.getName()==null);

        Cat cat2 = new Cat("George");
        Dog dog2 = new Dog("Steve");
        Animal animal2 = new Animal("Barf");

        assertTrue(cat2.getName().equals("George"));
        assertTrue(dog2.getName().equals("Steve"));
        assertTrue(animal2.getName().equals("Barf"));

        Cat cat3 = new Cat("");
        Dog dog3 = new Dog("");
        Animal animal3 = new Animal("");

        assertTrue(cat3.getName().equals(""));
        assertTrue(dog3.getName().equals(""));
        assertTrue(animal3.getName().equals(""));
    }

    @Test
    public void testFIFOAnimalShelter_cats() {
        FIFOAnimalShelter shelter = new FIFOAnimalShelter();

        Cat[] cats = makesCats();
        for (int i = 0; i < cats.length; i++) {
            shelter.enqueue(cats[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Cat.class).getName().equals(cats[i].getName()));
        }

        assertNull(shelter.dequeue(Cat.class));
    }

    @Test
    public void testFIFOAnimalShelter_dogs() {
        FIFOAnimalShelter shelter = new FIFOAnimalShelter();

        Dog[] dogs = makesDogs();
        for (int i = 0; i < dogs.length; i++) {
            shelter.enqueue(dogs[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Dog.class).getName().equals(dogs[i].getName()));
        }

        assertNull(shelter.dequeue(Dog.class));
    }

    @Test
    public void testFIFOAnimalShelter_other() {
        FIFOAnimalShelter shelter = new FIFOAnimalShelter();

        Animal[] animals = makesAnimals();
        for (int i = 0; i < animals.length; i++) {
            shelter.enqueue(animals[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Animal.class).getName().equals(animals[i].getName()));
        }

        assertNull(shelter.dequeue(Animal.class));
    }

    @Test
    public void testFIFOAnimalShelter_mixed() {
        FIFOAnimalShelter shelter = new FIFOAnimalShelter();

        Dog[] dogs = makesDogs();
        for (int i = 0; i < dogs.length; i++) {
            shelter.enqueue(dogs[i]);
        }

        Cat[] cats = makesCats();
        for (int i = 0; i < cats.length; i++) {
            shelter.enqueue(cats[i]);
        }

        Animal[] animals = makesAnimals();
        for (int i = 0; i < animals.length; i++) {
            shelter.enqueue(animals[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Cat.class).getName().equals(cats[i].getName()));
        }
        assertNull(shelter.dequeue(Cat.class));

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Dog.class).getName().equals(dogs[i].getName()));
        }
        assertNull(shelter.dequeue(Dog.class));

        for (int i = 0; i < 5; i++) {
            assertTrue(shelter.dequeue(Animal.class).getName().equals(animals[i].getName()));
        }
        assertNull(shelter.dequeue(Animal.class));
    }

    private static Cat[] makesCats() {
        Cat[] cats = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat(Integer.toString(i));
        }
        return cats;
    }

    private static Dog[] makesDogs() {
        Dog[] dogs = new Dog[5];
        for (int i = 0; i < 5; i++) {
            dogs[i] = new Dog(Integer.toString(i));
        }
        return dogs;
    }

    private static Animal[] makesAnimals() {
        Animal[] animals = new Animal[5];
        for (int i = 0; i < 5; i++) {
            animals[i] = new Animal(Integer.toString(i));
        }
        return animals;
    }

}
