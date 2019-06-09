import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        scanner.nextLine();

        String[] testArr = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            testArr[i] = scanner.nextLine();
        }

        for (String checkString : testArr)
            if (isVPS(checkString))
                System.out.println("YES");
            else
                System.out.println("NO");
    }

    private static boolean isVPS(String checkString) {
        //짝수가 아니면 절대 아님
        if (checkString.length() % 2 != 0)
            return false;
        //()가 있으면 없애자
        while (checkString.contains("()")) {
            checkString = checkString.replaceAll("\\(\\)", "");
        }

        return checkString.equals("");
    }
}
