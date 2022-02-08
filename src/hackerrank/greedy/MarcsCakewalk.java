package hackerrank.greedy;

import java.util.ArrayList;
import java.util.List;

public class MarcsCakewalk {
    public static void main(String[] args) {
        List<Integer> calorie = new ArrayList<>();
        calorie.add(5);
        calorie.add(10);
        calorie.add(7);

        long result = marcsCakewalk(calorie);
        System.out.println(result);
    }

    public static long marcsCakewalk(List<Integer> calorie) {
        long total = 0;
        calorie.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < calorie.size(); i++) {
            int c = calorie.get(i);
            total += Math.pow(2, i) * c;
        }

        return total;
    }
}
