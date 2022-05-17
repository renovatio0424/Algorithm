package programmers.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KNumber {
    public static void main(String[] args) {
        String input = Long.toString(1000000, 3);
        System.out.println(input);
        String[] inputArr = input.split("0");

        for (String inputE : inputArr) {
            if (inputE.isEmpty() || inputE.isBlank()) continue;
            System.out.println(Integer.parseInt(inputE));
        }


        String pattern1 = "0[0-9]0";
        String pattern2 = "[0-9]0";
        String pattern3 = "0[0-9]";
        String pattern4 = "^[0-9]$";

//        System.out.println("1: "+ input.matches(pattern1));
//        System.out.println("1: "+ input.matches(pattern2));
//        System.out.println("1: "+ input.matches(pattern3));
//        System.out.println("1: "+ input.matches(pattern4));
    }


}
