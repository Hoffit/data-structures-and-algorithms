package expedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class PlayAround2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line = "1:00 PM - 11:00 AM";
        int totalMinutes = 0;

        /**
         * FYI - I used IntelliJ IDE, and copied end code into hirevue.
         * Thoughts ...
         * Considered regex, bit of a rabbit hole.
         * Did first solution hard coding indices cause I thought I could get away with it based on problem description:
         *      hh:mm followed by AM' or 'PM', e.g. '09:05 AM
         * But - the test case does not follow that and instead has input with single digit time.
         * Finally decided to make it using substrings based on ':' and '-' chars.
         * I think a real production solution would likely have Java Date instances.
         */

        String startmeridiem = line.substring(
                line.indexOf('M') - 1,
                line.indexOf(' ') + 3
                );
        String endmeridiem = line.substring(
                line.lastIndexOf('M') - 1,
                line.lastIndexOf('M') + 1
        );
        int beginHours = Integer.parseInt(line.substring(
                0,
                line.indexOf(':'))
        );
        int endHours =  Integer.parseInt(line.substring(
                line.indexOf('-') + 2,
                line.lastIndexOf(':'))
        );
        int beginMinutes = Integer.parseInt(line.substring(
                line.indexOf(':') + 1,
                line.indexOf(':') + 2)
        );
        int endMinutes =  Integer.parseInt(line.substring(
                line.lastIndexOf(':') + 1,
                line.lastIndexOf(':') + 2)
        );

        if (startmeridiem.equals(endmeridiem)) {
            totalMinutes = (endHours - beginHours) * 60;
        }
        else if(startmeridiem.equals("AM")) {
            totalMinutes = ((endHours + 12) - beginHours) * 60;
        }
        else {
            totalMinutes = ((12 - beginHours) + endHours) * 60;
        }

        int minutes = 0;

        if( (endMinutes - beginMinutes) < 0) {
            minutes = 60 + (endMinutes - beginMinutes);
        }
        else {
            minutes = endMinutes - beginMinutes;
        }

        totalMinutes += minutes;
        System.out.println(totalMinutes);
    }
}