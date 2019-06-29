package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[][] videoArr = new int[testCase][testCase];

        for (int i = 0; i < testCase; i++) {
            String insert = String.format("%08d", scanner.nextInt());
            for (int j = 0; j < insert.length(); j++) {

                videoArr[i][j] = insert.charAt(j) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(videoArr));
        compressVideo(videoArr);
    }

    private static void compressVideo(int[][] videoArr) {
        //압축 가능 여부 확인
        if (enableCompress(videoArr) || videoArr.length == 1)
            System.out.println(videoArr[0][0]);
        else {
            int divisionLength = videoArr.length / 2;
            int[][] arr1 = new int[divisionLength][divisionLength];
            int[][] arr2 = new int[divisionLength][divisionLength];
            int[][] arr3 = new int[divisionLength][divisionLength];
            int[][] arr4 = new int[divisionLength][divisionLength];

            for (int i = 0; i < videoArr.length; i++) {
                for (int j = 0; j < videoArr[i].length; j++) {
                    if (i < videoArr.length / 2 && j < videoArr.length / 2) {
                        arr1[i][j] = videoArr[i][j];
                    } else if (i > videoArr.length / 2 && j < videoArr.length / 2) {
                        arr2[i - videoArr.length / 2][j] = videoArr[i][j];
                    } else if (i < videoArr.length / 2 && j > videoArr.length / 2) {
                        arr3[i][j - videoArr.length / 2] = videoArr[i][j];
                    } else {
                        arr4[i - videoArr.length / 2][j - videoArr.length / 2] = videoArr[i][j];
                    }
                }
            }
            printArrays(arr1, arr2, arr3, arr4);
        }
    }

    private static void printArrays(int[][] arr1, int[][] arr2, int[][] arr3, int[][] arr4) {
        System.out.print("(");
        compressVideo(arr1);
        System.out.print(")");
        System.out.print("(");
        compressVideo(arr2);
        System.out.print(")");
        System.out.print("(");
        compressVideo(arr3);
        System.out.print(")");
        System.out.print("(");
        compressVideo(arr4);
        System.out.print(")");
    }

    private static boolean enableCompress(int[][] videoArr) {
        for (int i = 0; i < videoArr.length; i++) {
            for (int j = 0; j < videoArr[i].length; j++) {
                if (videoArr[i][j] != videoArr[0][0]) {
                    return false;
                }
            }
        }

        return true;
    }
}
