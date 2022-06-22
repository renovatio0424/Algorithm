package programmers.greedy;

import java.util.*;

public class LifeBoat {
    public static void main(String[] args) {
        int[] people = new int[]{
//                10, 20, 30, 40, 50, 60
                70, 50, 80, 50,
//                70,80,50
//                100,90,80,70
        };
        int limit = 100;
        int result = solution(people, limit);
        System.out.println(result);
    }

    private static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            count++;
        }

        return count;
    }
}
