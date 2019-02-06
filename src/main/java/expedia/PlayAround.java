package expedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PlayAround {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            /**
             * Some thoughts -
             * tricky bit is seeing if its a letter, versus other char. Maybe a function available already.
             * Regular expression comes to mind as another alternative (Java Pattern could be used).
             * Also - ascii values are in a numeric range...so could check each char ascii value in range of letters
             * I'll go brute force loop on chars. BigO time is n, which probably can't be improved.
             * BigO space is n also, which probably could be improved to constant (1).
             */
            char[] charLine = line.toCharArray();
            boolean lastWasUpper = false;
            for(int i = 0; i < charLine.length; i++) {
                if(Character.isAlphabetic(charLine[i])) {
                    if (lastWasUpper) {
                        charLine[i] = Character.toLowerCase(charLine[i]);
                        lastWasUpper = false;
                    }
                    else {
                        charLine[i] = Character.toUpperCase(charLine[i]);
                        lastWasUpper = true;
                    }
                }
            }
            System.out.println(line);
        }
    }
}