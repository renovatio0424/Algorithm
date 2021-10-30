package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String[] inputArr = input.split(" ");

        x = Integer.parseInt(inputArr[0]);
        y = Integer.parseInt(inputArr[1]);
        int z = y * 100 / x;

        int result = binarySearch(0, 1_000_000_000, z);

        System.out.println(result);
    }

    private static int binarySearch(int start, int end, int target) {
        if (target >= 99) return -1;
        if (start >= end) return -1;

        int mid = (start + end) / 2;

        int winRate = (y + mid) * 100 / (x + mid);

        if (winRate == target) {
            return mid;
        } else if (winRate > target) {
            return binarySearch(start + 1, mid, target);
        } else {
            return binarySearch(mid, end - 1, target);
        }

    }
}
