package programmers.kakao19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PickDolls {
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
        System.out.println("result: " + result);
    }

    private static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> boardStackList = intArrayToStackList(board);
        int result = getBoomDolls(boardStackList, moves);
        return result;
    }

    private static int getBoomDolls(List<Stack<Integer>> boardStackList, int[] moves) {
        Stack<Integer> pickDollStack = new Stack<>();
        int boomCount = 0;

        for (int moveIdx : moves) {
            Stack<Integer> stackBoard = boardStackList.get(moveIdx - 1);

            if (stackBoard.isEmpty())
                continue;

            while (!stackBoard.isEmpty() && stackBoard.peek() == 0) {
                stackBoard.pop();
            }

            if (stackBoard.isEmpty())
                continue;

            int nonZeroDoll = stackBoard.pop();

            if (pickDollStack.isEmpty() || pickDollStack.peek() != nonZeroDoll) {
                pickDollStack.push(nonZeroDoll);
                continue;
            }

            if (pickDollStack.peek() == nonZeroDoll) {
                pickDollStack.pop();
                boomCount++;
            }
        }

        return boomCount;
    }

    private static List<Stack<Integer>> intArrayToStackList(int[][] board) {
        List<Stack<Integer>> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; i++) {
                Stack<Integer> boardStack = result.get(j);

                if (result.get(j) == null) {
                    boardStack = new Stack<>();
                    result.add(boardStack);
                }

                boardStack.push(board[i][j]);
            }
        }

        return result;
    }


}
