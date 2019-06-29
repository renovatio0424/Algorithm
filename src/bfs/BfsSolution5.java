package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BfsSolution5 {
    private static int[][] map;
    private static boolean[][] visitedMap;
    private static int complexCount = 0;
    private static ArrayList<Integer> buildingCountList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mapLength = scanner.nextInt();
        map = new int[mapLength][mapLength];
        visitedMap = new boolean[mapLength][mapLength];

        for (int i = 0; i < mapLength; i++) {
            int lineNumber = scanner.nextInt();
            String lineString = String.format("%0" + mapLength + "d", lineNumber);
            for (int j = 0; j < mapLength; j++) {
                map[i][j] = lineString.charAt(j) - 48;
            }
        }

        complexNumbering(map);

        System.out.println(Arrays.deepToString(map));
    }

    private static void complexNumbering(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!visitedMap[i][j] && map[i][j] != 0)
                    visitComplex(i, j, 0);
                else
                    visitedMap[i][j] = true;
            }
        }
    }

    private static void visitComplex(int i, int j, int buildingCount) {
        //맵 바깥으로 이동할 경우
        if (i >= map.length || j >= map.length)
            return;

        //다음 이동할 곳이 장외라면
        if (i - 1 >= map.length || i + 1 >= map.length || j - 1 >= map.length || j + 1 >= map.length)
            return;

        //방문한적이 없는 건물이면
        if (map[i - 1][j] == 1 && !visitedMap[i - 1][j]) {
            visitComplex(i - 1, j, buildingCount + 1);
        }
//        (i-1, j), (i+1,j), (i,j-1), (i,j+1)


    }
}
