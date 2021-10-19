package backjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Factor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int factorSize = scanner.nextInt();
        int[] factorArr = new int[factorSize];

        for (int i = 0; i < factorSize; i++) {
            factorArr[i] = scanner.nextInt();
        }

        int result = getN(factorArr);

        System.out.println(result);
    }

    private static int getN(int[] factorArr) {
        Arrays.sort(factorArr);
        int a = factorArr[0];
        int b = factorArr[factorArr.length - 1];
        return a * b;
    }
}
