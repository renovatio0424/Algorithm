package programmers.study;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
public class CheckDistance {
    public static void main(String[] args) {
        String[][] places = new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution(places);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String[][] places) {
        int[] answers = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            if (isValidDistance(places[i])) answers[i] = 1;
            else answers[i] = 0;
        }

        return answers;
    }

    private static boolean isValidDistance(String[] place) {
        char[][] placeArr = convertPlace(place);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (placeArr[i][j] == 'P') {
                    if (!isExceedManhatanDistance(j,i, placeArr)) return false;
                }
            }
        }
        return true;
    }

    private static char[][] convertPlace(String[] place) {
        char[][] result = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[i][j] = place[i].charAt(j);
            }
        }
        return result;
    }

    private static boolean isExceedManhatanDistance(int x1, int y1, char[][] place) {
        int[][] unEnableArr = new int[][]{
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };

        int[][] distance2Arr = new int[][]{
                {-2, 0},
                {0, 2},
                {0, -2},
                {2, 0}
        };

        int[][] crossArr = new int[][]{
                {-1, 1},
                {-1, -1},
                {1, 1},
                {1, -1},
        };

        for (int[] unEnable : unEnableArr) {
            int newX = x1 + unEnable[1];
            int newY = y1 + unEnable[0];

            if (newX < 0 || newX > 4 || newY < 0 || newY > 4) continue;

            if (place[newY][newX] == 'P') return false;
        }

        for (int[] distance2 : distance2Arr) {
            int newX = x1 + distance2[1];
            int newY = y1 + distance2[0];

            if (newX < 0 || newX > 4 || newY < 0 || newY > 4) continue;

            int gapX = (newX + x1)/2;
            int gapY = (newY + y1)/2;

            if (place[newY][newX] == 'P' && place[gapY][gapX] == 'O') return false;
        }

        for (int[] cross : crossArr) {
            int newX = x1 + cross[1];
            int newY = y1 + cross[0];

            if (newX < 0 || newX > 4 || newY < 0 || newY > 4) continue;

            int gapX1 = x1;
            int gapY1 = newY;

            int gapX2 = newX;
            int gapY2 = y1;

            if (place[newY][newX] == 'P' && place[gapY1][gapX1] == 'O' || place[newY][newX] == 'P' && place[gapY2][gapX2] == 'O') return false;
        }

        return true;
    }
}
