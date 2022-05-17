package Test;

import kotlin.text.Regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class TodayHouse {
    public static void main(String[] args) {
        String s = "this is {template}";
        System.out.println(Pattern.compile("\\{(\\w+)\\}").matcher(s).find());
        System.out.println(s.matches("\\{(\\w+)\\}"));
        System.out.println(s.replaceAll("\\{(\\w+)\\}", ""));




        String path = "EEESEEEEEENNNNN";

        Character current = null;
        int count = 0;
        int time = 0;

        String lower = path.toLowerCase();
        String sub = lower.substring(0, 0 + 10);
        HashMap<String, String> map = new HashMap<>();

        if (path.charAt(0) == '{');
        ArrayList<Integer> aList = new ArrayList<>();
        aList.clear();
        for (char direction : path.toCharArray()) {
            if (current == null) {
                current = direction;
                time++;
                continue;
            }

            if (current.equals(direction)) {
                count++;
                time++;
                continue;
            }


        }
    }
}
