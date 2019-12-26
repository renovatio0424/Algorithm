package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @link: https://www.acmicpc.net/problem/1463
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * <p>
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * <p>
 * <p>
 * input
 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 * <p>
 * output
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 * <p>
 * example
 * 2 -> 1
 * 10 -> 3
 */
public class MakeOne {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int time = makeOne(N);
        System.out.println(time);
    }

    private static int makeOne(int n) {
        if (n == 1)
            return 0;

        Queue<Pair> divideValueQue = new LinkedList<>();
        divideValueQue.add(new Pair(n, 0));

        while (!divideValueQue.isEmpty()) {
            Pair currentPair = divideValueQue.poll();
            int currentValue = currentPair.value;

            if (currentValue == 1) {
                return currentPair.operatingCount;
            }

            int nextValue;

            if (currentValue % 3 == 0) {
                nextValue = currentValue / 3;
                divideValueQue.add(new Pair(nextValue, currentPair.operatingCount + 1));
            }

            if (currentValue % 2 == 0) {
                nextValue = currentValue / 2;
                divideValueQue.add(new Pair(nextValue, currentPair.operatingCount + 1));
            }

            nextValue = currentValue - 1;
            divideValueQue.add(new Pair(nextValue, currentPair.operatingCount + 1));

        }

        return -1;
    }

    static class Pair {
        private int value = 0;
        private int operatingCount = 0;

        Pair(int value, int operatingCount) {
            this.value = value;
            this.operatingCount = operatingCount;
        }

        public int getValue() {
            return value;
        }

        public int getOperatingCount() {
            return operatingCount;
        }
    }
}
