package programmers.kakao22_blind;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/92342
public class ArcheryCompetition {
    public static void main(String[] args) {
        int n = 9;
        int[] info = new int[]{
                //2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0
                //1,0,0,0,0,0,0,0,0,0,0
                0,0,1,2,0,1,1,1,1,1,1
        };

        int[] result = solution(n, info);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int n, int[] info) {
        int[] max = new int[]{-1};
        int maxScore = 0;

        for (int i = 0; i < info.length; i++) {
            int[] ryanArrows = new int[info.length];
            makeRyanArr(i, n, info, ryanArrows);
            int ryanScore = countRyanTotalScore(info, ryanArrows);
            int apeachScore = countApeachTotalScore(info, ryanArrows);

            if (ryanScore > apeachScore && ryanScore >= maxScore) {
                max = ryanArrows;
                maxScore = ryanScore;
            }
        }

        return max;
    }

    private static void makeRyanArr(int start, int n, int[] info, int[] ryanArrows) {
        int totalArrow = 0;
        for (int i = start; i < ryanArrows.length; i++) {
            int arrow = info[i];
            int winArrow = arrow + 1;
            if (n >= winArrow + totalArrow) {
                ryanArrows[i] = winArrow;
                totalArrow += winArrow;
            }
        }
    }

    private static int countRyanTotalScore(int[] apeach, int[] ryan) {
        int ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] < ryan[i]) {
                ryanScore += 10 - i;
            }
        }
        return ryanScore;
    }

    private static int countApeachTotalScore(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] >= ryan[i] && apeach[i] > 0) {
                apeachScore += 10 - i;
            }
        }
        return apeachScore;
    }
}
