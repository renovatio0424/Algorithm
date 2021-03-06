package programmers.dfs;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println("result : " + result);
    }

    private static int factorial(int number) {
        if (number <= 1)
            return 1;

        return number * factorial(number - 1);
    }
}
