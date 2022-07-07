package programmers.dev_matching;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
//        int rows = 6;
//        int columns = 6;
//        int[][] queries = new int[][]{
//                {2, 2, 5, 4},
//                {3, 3, 6, 6},
//                {5, 1, 6, 3}
//        };

//        int rows = 3;
//        int columns = 3;
//        int[][] queries = new int[][]{
//                {1,1,2,2},
//                {1,2,2,3},
//                {2,1,3,2},
//                {2,2,3,3}
//        };

        int rows = 100;
        int columns = 97;
        int[][] queries = new int[][]{
                {1, 1, 100, 97},
        };

        int[] result = solution(rows, columns, queries);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        MatrixRotator matrixRotator = new MatrixRotatorImpl(rows, columns);
        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int min = matrixRotator.findMinimumChangedNumber(queries[i]);
            answer[i] = min;
        }

        return answer;
    }
}

class MatrixRotatorImpl implements MatrixRotator {
    private final int[][] matrix;

    MatrixRotatorImpl(int rows, int columns) {
        matrix = createMatrix(rows, columns);
    }

    private int[][] createMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        return matrix;
    }

    /**
     * @param start : { start column, start row } = { start x, start y }  => 1 base index
     * @param end   : { end column, end row } = { end x, end y } => 1 base index
     */
    private int rotateAndFindMinimumValue(int[] start, int[] end) {
        int startX = start[0] - 1;
        int startY = start[1] - 1;
        int endX = end[0] - 1;
        int endY = end[1] - 1;

        int prev = matrix[startY][startX];
        int min = prev;

        //top
        for (int x = startX + 1; x <= endX; x++) {
            prev = move(x, startY, prev);
            min = Math.min(min, prev);
        }

        //right
        for (int y = startY + 1; y <= endY; y++) {
            prev = move(endX, y, prev);
            min = Math.min(min, prev);
        }

        //bottom
        for (int x = endX - 1; x >= startX; x--) {
            prev = move(x, endY, prev);
            min = Math.min(min, prev);
        }

        //left
        for (int y = endY - 1; y > startY; y--) {
            prev = move(startX, y, prev);
            min = Math.min(min, prev);
        }

        return min;
    }

    private int move(int x, int y, int prev) {
        int tmp = matrix[y][x];
        matrix[y][x] = prev;
        prev = tmp;
        return prev;
    }

    /**
     * @param start : {start column, start row}
     * @param end   : {end column, end row}
     * @return outline arr
     * <p>
     * ex)
     * matrix
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * <p>
     * start = {1,1}
     * end = {2,2}
     * outline arr = {1, 2, 5, 4}
     */
    private int[] getOutLineArr(int[] start, int[] end) {
        int width = end[0] - start[0] + 1;
        int height = end[1] - start[1] + 1;
        int outlineLength = width * height - (width - 2) * (height - 2);
        int[] outlineArr = new int[outlineLength];

        int startX = start[0] - 1;
        int startY = start[1] - 1;
        int endX = end[0] - 1;
        int endY = end[1] - 1;

        //top
        int idx = 0;
        for (int x = startX; x <= endX; x++) {
            outlineArr[idx] = matrix[startY][x];
            idx++;
        }

        //right
        for (int y = startY + 1; y <= endY; y++) {
            outlineArr[idx] = matrix[y][endX];
            idx++;
        }

        //bottom
        for (int x = endX - 1; x >= startX; x--) {
            outlineArr[idx] = matrix[endY][x];
            idx++;
        }

        //left
        for (int y = endY - 1; y > startY; y--) {
            outlineArr[idx] = matrix[y][startX];
            idx++;
        }

        return outlineArr;
    }

    /**
     * @param start      : {start column, start row}
     * @param end        : {end column, end row}
     * @param outlineArr ex)
     *                   matrix
     *                   1 2 3
     *                   4 5 6
     *                   7 8 9
     *                   <p>
     *                   start = {1,1}
     *                   end = {2,2}
     *                   outline arr = {1, 2, 5, 4}
     */
    private void rotateAndFindMinimumValue(int[] start, int[] end, int[] outlineArr) {
        int startX = start[0] - 1;
        int startY = start[1] - 1;
        int endX = end[0] - 1;
        int endY = end[1] - 1;

        //top
        int idx = 0;

        //move last element to {startX, startY}
        matrix[startY][startX] = outlineArr[outlineArr.length - 1];

        for (int x = startX + 1; x <= endX; x++) {
            matrix[startY][x] = outlineArr[idx];
            idx++;
        }

        //right
        for (int y = startY + 1; y <= endY; y++) {
            matrix[y][endX] = outlineArr[idx];
            idx++;
        }

        //bottom
        for (int x = endX - 1; x >= startX; x--) {
            matrix[endY][x] = outlineArr[idx];
            idx++;
        }

        //left
        for (int y = endY - 1; y > startY; y--) {
            matrix[y][startX] = outlineArr[idx];
            idx++;
        }
    }

    private int findMinimumNumber(int[] outlineArr) {
        int min = Integer.MAX_VALUE;

        for (int element : outlineArr) {
            min = Math.min(min, element);
        }

        return min;
    }

    @Override
    public int findMinimumChangedNumber(int[] queries) {
        // query = {startY , startX, endY, endX}
        int[] start = new int[]{queries[1], queries[0]};
        int[] end = new int[]{queries[3], queries[2]};

//        int[] outlineArr = getOutLineArr(start, end);
//        int min = findMinimumNumber(outlineArr);
//        rotate(start, end, outlineArr);
//        return min;

        return rotateAndFindMinimumValue(start, end);
    }
}

interface MatrixRotator {
    int findMinimumChangedNumber(int[] queries);
}
