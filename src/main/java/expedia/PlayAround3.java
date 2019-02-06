package expedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class PlayAround3 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String[] lines = {
                "Hello World",
                "dello WorlW",
                "",
                "CodeEval",
                "Quick Fox",
                "A",
                "San Francisco"
        };

        int N = 3;

    /**
     * FYI - written in IntelliJ IDE and then copied to hirevue.
     * First thought is to create an ArrayList on input Strings, and then sort the list
     * by length, and finally loop through that ArrayList 0 - 'N' times printing out elements.
     * The thought crossed my mind that there would be something possible by overriding String's
     * comparator method, and in fact I found a slick solution for that here:
     * https://stackoverflow.com/questions/35866240/how-to-sort-string-array-by-length-using-arrays-sort
     * An unsorted version is also possible, where you loop through twice, the first time getting the lengths, and the second time printing.
     * Another solution might be a Hashmap with key of length.
     * I'll try that latter approach - since I've not done it before. Plus - I've got that solution now from stack overflow in my head
     * and I want to do something for which I've not seen code examples.
     */

        HashMap<Integer, String> lineMap = new HashMap<>();
        int max = 0;
        for(int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 0) {
                lineMap.put(lines[i].length(), lines[i]);
                max = Math.max(lines[i].length(), max);
            }
        }
        int numberPrinted = 0;
        for (int j = max; numberPrinted < N; j--) {
            if (lineMap.containsKey(j)) {
                System.out.println(lineMap.get(j));
                numberPrinted++;
            }
        }
        System.out.println(lineMap);
    }
}