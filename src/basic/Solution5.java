package basic;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] widthAndHeight = new int[2];
        int[] initialPosition = new int[2];
        int duration;
        String whString = scanner.nextLine();
        String initPosition = scanner.nextLine();
        duration = scanner.nextInt();

        for (int i = 0; i < widthAndHeight.length; i++) {
            widthAndHeight[i] = Integer.parseInt(whString.split(" ")[i]);
            initialPosition[i] = Integer.parseInt(initPosition.split(" ")[i]);
        }

        findAntPosition(widthAndHeight, initialPosition, duration);
    }

    private static void findAntPosition(int[] widthAndHeight, int[] initialPosition, int duration) {
        int x = moveAnt(widthAndHeight[0], initialPosition[0], duration);
        int y = moveAnt(widthAndHeight[1], initialPosition[1], duration);

        System.out.println(x + " " + y);
    }

    private static int moveAnt(int length, int initPosition, int duration) {
        int position = initPosition + duration;
        int quotient = position / length;
        int remainder = position % length;

        if (quotient % 2 == 0)
            position = remainder;
        else
            position = length - remainder;

        return position;
    }
}