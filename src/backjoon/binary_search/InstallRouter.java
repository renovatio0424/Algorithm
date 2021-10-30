package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InstallRouter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int c = Integer.parseInt(inputArr[1]);

        int[] houseArr = new int[n];
        for (int i = 0; i < n; i++) {
            houseArr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int result = findMaximumRouterDistance(houseArr, c);

        System.out.println(result);
    }

    private static int findMaximumRouterDistance(int[] houseArr, int routerCount) {
        Arrays.sort(houseArr);

        int start = 0;
        int end = houseArr.length - 1;
        int maximumDistance = houseArr[end] - houseArr[start];
        int count = 2;

        while (count < routerCount) {
            int mid = (start + end) / 2;

            int leftDistance = houseArr[mid] - houseArr[start];
            int rightDistance = houseArr[end] - houseArr[mid];


            if (leftDistance >= rightDistance) {
               end = mid - 1;
            } else {
                start = mid + 1;
            }

            int adjDistance = Math.min(leftDistance, rightDistance);
            maximumDistance = Math.min(maximumDistance, adjDistance);
            count++;
        }

        return maximumDistance;
    }
}
