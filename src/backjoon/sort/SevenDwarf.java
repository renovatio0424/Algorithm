package backjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] heightArr = new int[9];

        for (int i = 0; i < 9; i++) {
            heightArr[i] = scanner.nextInt();
        }

        int[] dwarfArr = getDwarfList(heightArr);

        for (int answer : dwarfArr) {
            System.out.println(answer);
        }
    }

    private static int[] getDwarfList(int[] heightArr) {
        Arrays.sort(heightArr);
        int[] resultArr = new int[7];

        int sum = 0;
        for (int i = 0; i < heightArr.length; i++) {
            sum += heightArr[i];
        }

        int answer = sum - 100;
        // (0,1), (0,2) ..
        for (int i = 0; i < heightArr.length - 1; i++) {
            boolean isFind = false;
            for (int j = i + 1; j < heightArr.length; j++) {
                int twoSum = heightArr[i] + heightArr[j];
                if (twoSum == answer) {
                    heightArr[i] = 0;
                    heightArr[j] = 0;
                    isFind = true;
                    break;
                }
            }
            if(isFind) break;
        }

        int current = 0;

        for (int i = 0; i < heightArr.length; i++) {
            if (heightArr[i] != 0) {
                resultArr[current] = heightArr[i];
                current++;
            }
        }

        Arrays.sort(resultArr);

        return resultArr;
    }
}
