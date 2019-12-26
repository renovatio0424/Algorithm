package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * <p>
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * <p>
 *
 * input
 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 *
 * output
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * example
 * 2 -> 1
 * 10 -> 3
 */
public class MakeOne {
    private static int N;
    private static int[] timeList = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int time = makeOne(N);
        System.out.println(time);
    }

    private static int makeOne(int n) {
        Queue<Integer> divideValueQue = new LinkedList<>();
        divideValueQue.add(n);

        while (!divideValueQue.isEmpty()) {
            int currentValue = divideValueQue.poll();

            if (currentValue == 1) {
                return timeList[currentValue] - 1;
            }

            int nextValue;

            if (currentValue % 3 == 0) {
                nextValue = currentValue / 3;
            } else if (currentValue % 2 == 0) {
                nextValue = currentValue / 2;
            } else {
                nextValue = currentValue - 1;
            }
            divideValueQue.add(nextValue);
            timeList[nextValue] = timeList[currentValue] + 1;

        }

        return -1;
    }
}
