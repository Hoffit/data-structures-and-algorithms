import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        //test case 1
        int[] inputArray = {1, 2, 3, 4};
        int searchValue = 3;
        assertEquals(2, binarySearch.binarySearch(inputArray, searchValue));

        //test case 2
        int[] inputArray2 = {1, 2, 3, 4, 5};
        searchValue = 1;
        assertEquals(0, binarySearch.binarySearch(inputArray2, searchValue));

        //test case 3
        int[] inputArray3 = {1, 2, 3, 4, 5};
        searchValue = 7;
        assertEquals(-1, binarySearch.binarySearch(inputArray3, searchValue));

        //test case 4
        int[] inputArray4 = {1, 2, 3, 4, 5, 7};
        searchValue = 7;
        assertEquals(5, binarySearch.binarySearch(inputArray4, searchValue));
    }
}