/**
 * Java class for lab 02 challenge.
 */
public class ArrayShift {

    /**
     * This method will insert the provided valueToInsert into the middle of arrayToShift.
     * For even length array, the insert is length/2.
     * For odd length array, the insert is length/2 + 1.
     * @param arrayToShift The array in which to insert valueToInsert.
     * @param valueToInsert The value to insert.
     * @return A new array with the inserted value.
     */
    protected int[] insertShiftArray(int[] arrayToShift, int valueToInsert) {
        int[] returnArray = new int[arrayToShift.length+1];
        int index;
        if (arrayToShift.length%2==0)
            index = arrayToShift.length/2;
        else
            index = arrayToShift.length/2+1;
        for (int i=0; i<returnArray.length;i++) {
            if (i<index)
                returnArray[i] = arrayToShift[i];
            else if (i>index)
                returnArray[i]  = arrayToShift[i-1];
            else if (i == index)
                returnArray[i] = valueToInsert;
        }
        return returnArray;
    }
}
