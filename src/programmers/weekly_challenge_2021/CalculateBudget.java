package programmers.weekly_challenge_2021;

public class CalculateBudget {
    //https://programmers.co.kr/learn/courses/30/lessons/82612?language=java

    public static void main(String[] args) {
        int price = 2500; // 1 ~ 2500
        int money = 1000000000; //1 ~ 1,000,000,000
        int count = 2500; //1 ~ 2500
        int result = 10;

        long remain = solution(price, money, count);
        System.out.println(remain);
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long totalExpense = 0L;

        for (int i = 1; i < count + 1; i++) {
            totalExpense += (long) i * price;
        }

        answer = money - totalExpense;

        if (answer < 0)
            return Math.abs(answer);

        return 0;
    }
}
