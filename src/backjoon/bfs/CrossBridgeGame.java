package backjoon.bfs;

import java.util.Scanner;
import java.util.Stack;

public class CrossBridgeGame {
    private static boolean[][] visitedArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int J = scanner.nextInt();
        int K = scanner.nextInt();

        visitedArr = new boolean[2][N];

        int[][] jBridgeArr = new int[J][2];
        for (int i = 0; i < J; i++) {
            jBridgeArr[i][0] = scanner.nextInt() - 1;
            jBridgeArr[i][1] = scanner.nextInt() - 1;
        }

        int[][] kBridgeArr = new int[K][2];
        for (int i = 0; i < K; i++) {
            kBridgeArr[i][0] = scanner.nextInt() - 1;
            kBridgeArr[i][1] = scanner.nextInt() - 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N - 1; i++) {
            visitedArr = null;
            visitedArr = new boolean[2][N];
            char winner = getWinner(i, i, N - 1, jBridgeArr, kBridgeArr);
            sb.append(winner);
        }

        System.out.println(sb.toString());
    }

    private static char getWinner(int jStartIdx, int kStartIdx, int endIdx, int[][] jBridgeArr, int[][] kBridgeArr) {
        Stack<int[]> moveStack = new Stack<>();
        moveStack.push(new int[]{jStartIdx, kStartIdx});

        while (true) {
            int[] currentIdxArr = moveStack.pop();

            int jBefore = currentIdxArr[0];
            int kBefore = currentIdxArr[1];
            int jCurrentIdx = currentIdxArr[0];
            int kCurrentIdx = currentIdxArr[1];

            if (jCurrentIdx == endIdx) {
                return 'J';
            } else if (kCurrentIdx == endIdx) {
                return 'K';
            }

            visitedArr[0][jCurrentIdx] = true;
            visitedArr[1][kCurrentIdx] = true;

            //j turn - 움직임
            for (int[] jBridge : jBridgeArr) {
                if (jBridge[0] == jCurrentIdx) {
                    jCurrentIdx = jBridge[1];
                    break;
                }
            }

            //k turn - 움직임
            for (int[] kBridge : kBridgeArr) {
                if (kBridge[0] == jCurrentIdx) {
                    kCurrentIdx = kBridge[1];
                    break;
                }
            }

            if (jCurrentIdx == jBefore && kCurrentIdx == kBefore || visitedArr[0][jCurrentIdx] && visitedArr[1][kCurrentIdx]) {
                return 'D';
            }

            moveStack.push(new int[]{jCurrentIdx, kCurrentIdx});
        }

//        return getWinner(jCurrentIdx, kCurrentIdx, endIdx, jBridgeArr, kBridgeArr);
    }
}
