package basic;

import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[][] pairTestCase = new int[testCase][2];

        for (int i = 0; i < testCase; i++) {
            pairTestCase[i][0] = scanner.nextInt();
            pairTestCase[i][1] = scanner.nextInt();
        }

        for (int[] ints : pairTestCase) {
            printAllPrimaryNumber(ints);
//            int count = countPrimaryNumberChangeStep(ints);
//            if (count != -1)
//                System.out.println(count);
//            else
//                System.out.println("Impossible");
        }
    }

    private static void printAllPrimaryNumber(int[] primaryPair) {
        for (int i = Math.min(primaryPair[0], primaryPair[1]); i < Math.max(primaryPair[0], primaryPair[1]); i++) {
            if (isPrimaryNumber(i))
                System.out.println(i);
        }
    }

    private static boolean isPrimaryNumber(int number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0)
                return false;
        }

        return true;
    }

    private static int countPrimaryNumberChangeStep(int[] primaryPair) {

        return 0;
    }


}
