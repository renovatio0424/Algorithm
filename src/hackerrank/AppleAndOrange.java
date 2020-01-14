package hackerrank;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 *
 * */

import java.util.Scanner;

public class AppleAndOrange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // home range = s~t
        // apple tree point = a
        // orange tree point = b

        int numberOfMyApples = 0;
        int numberOfMyOranges = 0;

        for (int appleLocation: apples) {
            if(isInHomeRange(s,t,a,appleLocation))
                numberOfMyApples++;
        }

        for (int orangeLocation: oranges) {
            if(isInHomeRange(s,t,b,orangeLocation))
                numberOfMyOranges++;
        }

        System.out.println(numberOfMyApples);
        System.out.println(numberOfMyOranges);
    }

    private static boolean isInHomeRange(int start, int end, int tree, int location) {
        return start <= tree + location && tree + location <= end;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}

