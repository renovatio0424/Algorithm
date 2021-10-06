package backjoon.implementation;

import java.util.Scanner;

public class FactorNMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0 0")) break;

            String[] inputArr = input.split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);

            String result = checkFactorAndMultiple(a, b);

            System.out.println(result);
        }
    }

    private static String checkFactorAndMultiple(int a, int b) {
        if (b / a > 1 && b % a == 0)
            return "factor";
        else if (a / b > 1 && a % b == 0)
            return "multiple";
        else
            return "neither";
    }
}
