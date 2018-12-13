package fifoanimalshelter;

/**
 * Class the can be used to reprsent animal instances. See subtypes for more specific animals.
 */
public class Animal {

    /**
     * The given name of the animal.
     */
    private String name;

    /**
     * Default constructor.
     */
    public Animal() {
        super();
    }

    /**
     * Constructor.
     * @param name The animal's given name.
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Getter.
     * @return The animals given name.
     */
    public String getName() {
        return name;
    }
}
