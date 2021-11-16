package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int result = countReverse(input);

        System.out.println(result);
    }

    private static int countReverse(String input) {
        int firstNumber = input.charAt(0) - '0';
        int lastNumber = input.charAt(input.length() - 1) - '0';
        int currentNumber = firstNumber;
        int countOfChange = 0;

        for (char numChar : input.toCharArray()) {
            int newNumber = numChar - '0';
            if (currentNumber != newNumber) countOfChange++;
            currentNumber = newNumber;
        }


        if (firstNumber != lastNumber)
            return (countOfChange + 1) / 2;
        else
            return countOfChange / 2;
    }
}
