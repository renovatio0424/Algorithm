package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int oldHour = Integer.parseInt(s.substring(0, 2));
        int newHour = 0;
        if (s.contains("AM")) {
            if (oldHour == 12) {
                newHour = oldHour - 12;
            } else {
                newHour = oldHour;
            }
            s = s.replace("AM", "");
        }
        //PM
        else {
            if (oldHour != 12) {
                newHour = oldHour + 12;
            } else {
                newHour = oldHour;
            }
            s = s.replace("PM", "");
        }

        return s.replace(String.format("%02d", oldHour), String.format("%02d", newHour));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}

