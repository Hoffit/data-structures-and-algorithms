import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test Class for ArrayShift.
 */
public class ArrayShiftTest {

    /**
     * Test assertions for method ArrayShift.insertShiftArray()
     */
    @Test public void test() {
        ArrayShift arrayShift = new ArrayShift();

        //test case 1
        int[] inputArray = {1, 2, 3, 4};
        int[] expected = {1, 2, 5, 3, 4};
        assertArrayEquals(expected, arrayShift.insertShiftArray(inputArray, 5));

        //test case 2
        int[] inputArray2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 6, 4, 5};
        assertArrayEquals(expected2, arrayShift.insertShiftArray(inputArray2, 6));

        //test case 3: input ([], 5) => expected output
        int[] inputArray3 = {};
        int[] expected3 = {5};
        assertArrayEquals(expected3, arrayShift.insertShiftArray(inputArray3, 5));
    }
}
