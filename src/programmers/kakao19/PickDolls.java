package programmers.kakao19;

import java.util.*;

/**
 *  @link https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class PickDolls {
    // 4
    // 3
    // 1
    // 1
    // 3
    //
    //
    // 4
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution(board, moves);
        int hello = Integer.parseInt("123");
        System.out.println("result: " + result);
    }

    private static int solution(int[][] board, int[] moves) {
        List<Queue<Integer>> boardStackList = intArrayToQueueList(board);
        return getBoomDolls(boardStackList, moves);
    }

    private static int getBoomDolls(List<Queue<Integer>> boardStackList, int[] moves) {
        Stack<Integer> pickDollStack = new Stack<>();
        int boomCount = 0;

        for (int moveIdx : moves) {
            Queue<Integer> queueBoard = boardStackList.get(moveIdx - 1);

            if (queueBoard.isEmpty())
                continue;

            while (!queueBoard.isEmpty() && queueBoard.peek() == 0) {
                queueBoard.poll();
            }

            if (queueBoard.isEmpty())
                continue;

            int nonZeroDoll = queueBoard.poll();

            if (pickDollStack.isEmpty() || pickDollStack.peek() != nonZeroDoll) {
                pickDollStack.push(nonZeroDoll);
                continue;
            }

            if (pickDollStack.peek() == nonZeroDoll) {
                pickDollStack.pop();
                boomCount++;
            }
        }

        return boomCount * 2;
    }

    private static List<Queue<Integer>> intArrayToQueueList(int[][] board) {
        List<Queue<Integer>> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Queue<Integer> boardQueue;
                if (i == 0) {
                    boardQueue = new LinkedList<>();
                    result.add(boardQueue);
                }
                boardQueue = result.get(j);
                boardQueue.add(board[i][j]);
            }
        }

        return result;
    }


}
