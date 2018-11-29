/**
 * This is a CF 401 day 3 code challenge Java class.
 * Algorithm based on wiki: https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
public class BinarySearch {

    /**
     * A method that can be used to search input sortedArray for value searchValue.
     * @param sortedArray The input array to search. Must be sorted.
     * @param searchValue The value to search for in sortedArray.
     * @return The index in the sortedArray where searchKey is located.
     */
    protected int binarySearch(int[] sortedArray, int searchValue) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;
        int middle;
        while (rightIndex >= leftIndex) {
            middle = (leftIndex + rightIndex) / 2;
            if (sortedArray[middle] == searchValue) {
                return middle;
            }
            else if (sortedArray[middle] < searchValue) {
                leftIndex = middle + 1;
            }
            else if (sortedArray[middle] > searchValue) {
                rightIndex = middle -1;
            }
        }
        return -1;
    }
}
