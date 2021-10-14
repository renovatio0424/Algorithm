package backjoon.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SafeArea {
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        scanner.nextLine();

        boolean[][] plane = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            //start rect
            int startX = Integer.parseInt(inputArr[0]);
            int startY = Integer.parseInt(inputArr[1]);
            //end rect
            int endX = Integer.parseInt(inputArr[2]);
            int endY = Integer.parseInt(inputArr[3]);

            createRectOnPlane(startX, startY, endX, endY, plane);
        }

        printArea(plane);
    }

    private static void printArea(boolean[][] plane) {
        ArrayList<Integer> areaSizeList = new ArrayList<>();

        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[0].length; j++) {
                int areaSize = countArea(i, j, plane);
                if (areaSize != 0)
                    areaSizeList.add(areaSize);
            }
        }

        Collections.sort(areaSizeList);

        System.out.println(areaSizeList.size());
        for (int i = 0; i < areaSizeList.size(); i++) {
            System.out.print(areaSizeList.get(i) + " ");
        }
    }

    private static int countArea(int i, int j, boolean[][] plane) {
        if (i < 0 || i >= plane.length || j < 0 || j >= plane[0].length) {
            return 0;
        }

        if (plane[i][j] || visited[i][j])
            return 0;

        visited[i][j] = true;

        int right = countArea(i + 1, j, plane);
        int left = countArea(i - 1, j, plane);
        int down = countArea(i, j + 1, plane);
        int up = countArea(i, j - 1, plane);

        return right + down + left + up + 1;
    }

    private static void createRectOnPlane(int startX, int startY, int endX, int endY, boolean[][] plane) {
        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[0].length; j++) {
                if (startX <= j && j < endX && startY <= i && i < endY) {
                    plane[i][j] = true;
                }
            }
        }
    }
}
