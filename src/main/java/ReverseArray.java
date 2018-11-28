public class ReverseArray {

    public static void main(String[] args) {

        String[] someStrings = {
                "reverse",
                "to",
                "strings",
                "of",
                "set",
                "A"
        };
        String[] someOtherStrings = {
                "reverse",
                "to",
                "strings",
                "of",
                "set",
                "test",
                "Another"
        };

        printAsSentence(reverseArray(someStrings));
        printAsSentence(reverseArray(someOtherStrings));
    }

    /**
     * Code challenge - reverse an array of strings.
     * @param stringToReverse
     * @return
     */
    private static String[] reverseArray(String[] stringToReverse) {
        int arrayLength = stringToReverse.length;
        String[] returnString = new String[arrayLength];


        int returnStringArrayIndex = 0;
        for(int i=arrayLength-1; i>=0; i--) {
            returnString[returnStringArrayIndex] = stringToReverse[i];
            returnStringArrayIndex++;
        }

        return returnString;
    }

    /**
     * Take in the array of strings, and print them pretty as a sentence.
     * @param someArrayOfStrings
     */
    private static void printAsSentence(String[] someArrayOfStrings) {
        int arrayLength = someArrayOfStrings.length;
        for(int i=0; i<arrayLength; i++) {
            System.out.print(someArrayOfStrings[i]);
            if(i<arrayLength-1) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
