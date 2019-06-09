import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] widthAndHeight = new int[2];
        int[] initialPosition = new int[2];
        int duraion;
        String whString = scanner.nextLine();
        String initPosition = scanner.nextLine();
        duraion = scanner.nextInt();
        
        for (int i = 0; i < widthAndHeight.length; i++) {
            widthAndHeight[i] = Integer.parseInt(whString.split(" ")[i]);
            initialPosition[i] = Integer.parseInt(initPosition.split(" ")[i]);
        }
        
        findAntPosition(widthAndHeight, initialPosition, duraion);
    }

    private static void findAntPosition(int[] widthAndHeight, int[] initialPosition, int duraion) {
    }
}
