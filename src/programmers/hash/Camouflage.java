package programmers.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        HashMap<Integer, Integer> pointMap= new HashMap<>();
        int result = solution(clothes);
        System.out.println(result);
    }

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> clotheMap = new HashMap<>();

        for (String[] clotheArr : clothes) {
            String clotheCategory = clotheArr[1];

            int clotheCount = clotheMap.getOrDefault(clotheCategory, 0);
            clotheMap.put(clotheCategory, ++clotheCount);
        }

        int count = 1;
        for (Map.Entry<String, Integer> clothEntry : clotheMap.entrySet()) {
            count *= clothEntry.getValue() + 1;
        }

        return --count;
    }
}
