package basic;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[] testArr = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            testArr[i] = scanner.nextInt();
        }

        findSymmetryInt(testArr);
    }

    private static void findSymmetryInt(int[] arr) {
        //int -> string
        //숫자 뒤집기
        //string -> int
        //숫자 합하기
        //대칭 확인

        for (int i = 0; i < arr.length; i++) {
            int changeInt = changeInteger(arr[i]);
            int sum = arr[i] + changeInt;
            if (isSymmetry(sum))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean isSymmetry(int sum) {
        String stringSum = String.valueOf(sum);
        for (int i = 0; i < stringSum.length(); i++) {
            if (stringSum.charAt(i) != stringSum.charAt(stringSum.length() - 1 - i))
                return false;
        }

        return true;
    }

    private static int changeInteger(int i) {
        String stringInt = String.valueOf(i);
        StringBuilder changeInt = new StringBuilder(stringInt);

        for (int j = 0; j < stringInt.length() / 2; j++) {
            int indexA = j;
            int indexB = stringInt.length() - 1 - j;
            char a = stringInt.charAt(indexA);
            char b = stringInt.charAt(indexB);
            changeInt.setCharAt(indexB, a);
            changeInt.setCharAt(indexA, b);
        }

        return Integer.parseInt(changeInt.toString());
    }
}
