import java.util.Arrays;
import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int[][] passwordArr = new int[testCase][2];

        for (int i = 0; i < testCase; i++) {
            passwordArr[i][0] = scanner.nextInt();
            passwordArr[i][1] = scanner.nextInt();
        }

        for (int[] password : passwordArr)
            checkChangePasswordStep(password);
    }

    private static void checkChangePasswordStep(int[] password) {
        int step = 0;
        int beforePassword = password[0];

        do {
            //바로 변경한다

            if (isPrimeNumber())
                step++;

            //불가능한 경우 System.out.println("Impossible")
        } while (beforePassword == password[2]);

        System.out.println(step);
    }

    private static boolean isPrimeNumber() {
        return false;
    }
}
