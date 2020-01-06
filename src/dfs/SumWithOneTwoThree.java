package dfs;

import java.util.Scanner;
import java.util.Stack;

/**
 * [problems]
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * <p>
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * [input]
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 * <p>
 * [output]
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 * <p>
 * [example]
 * input
 * 3
 * 4
 * 7
 * 10
 * <p>
 * output
 * 7
 * 44
 * 274
 */

public class SumWithOneTwoThree {
    private static int totalSumCaseCount = 0;
    private static Stack<Integer> sumStack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseCount = scanner.nextInt();

        int[] caseArr = new int[caseCount];

        for (int i = 0; i < caseCount; i++) {
            caseArr[i] = scanner.nextInt();
        }

        for (int j = 0; j < caseCount; j++) {
            countTotalSumCase(caseArr[j], 0);
            System.out.println(totalSumCaseCount);
        }

    }

    private static void countTotalSumCase(int number, int currentSum) {
        if(currentSum == 0)
            totalSumCaseCount = 0;

        if (number == currentSum) {
            totalSumCaseCount++;
            return;
        } else if (number < currentSum) {
            return;
        }

        countTotalSumCase(number, currentSum + 1);
        countTotalSumCase(number, currentSum + 2);
        countTotalSumCase(number, currentSum + 3);
    }
}
