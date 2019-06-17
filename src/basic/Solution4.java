package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();

        String[] testArr = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            testArr[i] = scanner.nextLine();
        }

        sortVocabulary(testArr);
    }

    private static void sortVocabulary(String[] arr) {
        //중복 제거 -> hashset 사용
        String[] sortArr = new HashSet<>(Arrays.asList(arr)).toArray(new String[0]);

        Arrays.sort(sortArr, (o1, o2) -> {
            if (o1.length() < o2.length())
                return -1;
            else if (o1.length() > o2.length())
                return 1;
            else //o1.length == o2.length
                return o1.compareTo(o2);
        });

        for (String result : sortArr)
            System.out.println(result);
    }
}
