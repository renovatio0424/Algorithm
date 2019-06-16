import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] sudokuProblem = new int[9][9];
        int[][] sudokuSolution = new int[9][9];

        for (int i = 0; i < sudokuProblem.length; i++) {
            for (int j = 0; j < sudokuProblem[i].length; j++) {
                sudokuProblem[i][j] = scanner.nextInt();
            }
        }

        solveSudoku(sudokuProblem, sudokuSolution);

        for (int i = 0; i < sudokuSolution.length; i++) {
            for (int j = 0; j < sudokuSolution[i].length; j++) {
                System.out.print(sudokuSolution[i][j]);
                if (j != sudokuSolution[i].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(int[][] problem, int[][] solution) {
        //한줄에 각기 다른 숫자가 들어가 있는가?
        for (int i = 0; i < problem.length; i++) {
            HashMap zeroList = new HashMap();

            for(int j = 0 ; j < problem[i].length ; j++)
//                if(problem[i][j] == 0) zeroList.add(j);



            if (!isLineCheckSuccess(problem[i]))
                return;
        }
        //3x3에 각기 다른 숫자가 들어가 있는가? -> 1~9까지 합 1,9 / 2,8 / 3,7 / 4,6 / 5 = 45
        //입력할 수 있는 숫자
    }

    private static boolean isLineCheckSuccess(int[] intArr) {
        int sum = 0;
        for(int value : intArr){
            sum += value;
        }
        return sum == 45;// 1~9까지의 합 = 45
    }
}
