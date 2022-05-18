package programmers.kakao21_internship;

import java.util.HashMap;
import java.util.Map;

public class NumberStringAndEnglishWord {
    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);
        System.out.println(result);
    }

    private static int solution(String s) {
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        for (Map.Entry<String, Integer> entry : numberMap.entrySet()) {
            if (s.contains(entry.getKey())) {
                s = s.replaceAll(entry.getKey(), "" + entry.getValue());
            }
        }

        return Integer.parseInt(s);
    }
}
