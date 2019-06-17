package basic;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int scale = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        checkScale(scale);
    }

    private static void checkScale(int scale) {
        int ascending = 12345678;
        int descending = 87654321;

        if(scale == ascending)
            System.out.println("ascending");
        else if(scale == descending)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
