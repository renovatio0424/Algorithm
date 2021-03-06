package programmers.dynamic_programming;

public class Fibonazzi {
    public static int[] data = new int[100];

    public static void main(String[] args) {
        int number = 30;
        int result = finonazzi(number);
        System.out.println("result: " + result);
    }

    private static int finonazzi(int number) {
        if (number <= 2)
            return 1;

        if (data[number] == 0) {
            data[number] = finonazzi(number - 1) + finonazzi(number - 2);
        }

        return data[number];
    }
}
