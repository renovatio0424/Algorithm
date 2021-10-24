package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};

        String result = solution(numbers);

        System.out.println(result);
    }

    private static String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                Integer number1 = Integer.parseInt(o1 + o2);
                Integer number2 = Integer.parseInt(o2 + o1);

                return number1.compareTo(number2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = stringNumbers.length - 1; i >= 0; i--) {
            if (i == stringNumbers.length - 1 && Integer.parseInt(stringNumbers[i]) == 0)
                return "0";
            sb.append(stringNumbers[i]);
        }

        return sb.toString();
    }
}
