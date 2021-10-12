package backjoon.dfs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class IslandCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int h = scanner.nextInt();

        ArrayList<Integer> resultList = new ArrayList();

        while (w != 0 || h != 0) {
            int[][] islandArr = new int[h][w];

            for (int i = 0; i < islandArr.length; i++) {
                for (int j = 0; j < islandArr[0].length; j++) {
                    islandArr[i][j] = scanner.nextInt();
                }
            }

            int result = getIslandCount(islandArr);
            resultList.add(result);
            w = scanner.nextInt();
            h = scanner.nextInt();
        }

        for (int result : resultList) {
            System.out.println(result);
        }
    }

    private static int getIslandCount(int[][] islandArr) {
        Stack<Point> pointStack = new Stack<>();
        boolean[][] visited = new boolean[islandArr.length][islandArr[0].length];
        int[][] moveArr = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };

        int islandCount = 0;

        for (int i = 0; i < islandArr.length; i++) {
            for (int j = 0; j < islandArr[0].length; j++) {
                if (!visited[i][j] && islandArr[i][j] == 1) {
                    dfsIsland(islandArr, pointStack, visited, moveArr, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private static void dfsIsland(int[][] islandArr, Stack<Point> pointStack, boolean[][] visited, int[][] moveArr, int i, int j) {
        pointStack.push(new Point(j, i));

        while (!pointStack.isEmpty()) {
            Point current = pointStack.pop();

            if (current.x < 0 || current.x >= islandArr[0].length || current.y < 0 || current.y >= islandArr.length) {
                continue;
            }

            if (visited[current.y][current.x] || islandArr[current.y][current.x] == 0){
                continue;
            }

            visited[current.y][current.x] = true;

            for (int k = 0; k < moveArr.length; k++) {
                Point movePoint = current.clone();

                movePoint.x += moveArr[k][0];
                movePoint.y += moveArr[k][1];

                pointStack.push(movePoint);
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point clone() {
            return new Point(x, y);
        }
    }
}
