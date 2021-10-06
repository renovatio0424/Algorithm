package backjoon.greedy;

import java.util.Scanner;

public class MissingBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = getMinimumValue(input);

        System.out.println(result);

    }

    private static int getMinimumValue(String input) {
        String[] inputArr = input.split("-");
        int result = 0;

        for (int i = 0; i < inputArr.length; i++) {
            String[] plusStringArr = inputArr[i].split("\\+");

            int plus = 0;
            for (String plusString : plusStringArr) {
                plus += Integer.parseInt(plusString);
            }

            if (i == 0) {
                result = plus;
                continue;
            }

            result -= plus;
        }

        return result;
    }
}
