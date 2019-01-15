# Hashtables
Implement a hashtable.

## Challenge
Implement a Hashtable with the following capabilities

a method/function named add that takes in both the key and value. This method should hash the key and add the key and value pair to the table.
A method/function named Find that takes in the key and returns the value from key/value pair.
A method/function named contains that takes in the key and returns if the key exists in the table already.
A method/function named GetHash that takes in a key and returns the index in the array the key is stored.

## Approach & Efficiency
This helped develop a solution: https://codefellows.github.io/common_curriculum/data_structures_and_algorithms/Code_401/class-20/resources/Hashtables.html

### add, find, contains, getHash

#### add, contains, getHash
Big O(1) time.
Big O(1) space.

Note on the add and contains functions --> uses Java's ArrayList contains method, which is Big O (1)

#### find
Big O(n) time.
Big O(1) space.

## API
See Javadoc: https://hoffit.github.io/data-structures-and-algorithms/hashtable/package-summary.html
