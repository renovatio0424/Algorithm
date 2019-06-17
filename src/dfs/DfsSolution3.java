package dfs;

import java.util.Scanner;

public class DfsSolution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String insert = scanner.nextLine();

        int result = calculateBracket(insert);
    }

    private static int calculateBracket(String insert) {
        //닫혀있는 괄호가 있나?
        for (int i = 0; i < insert.length(); i++) {


            if (insert.charAt(0) == '(' && insert.charAt(i) == ')') {//첫번째 글자와 닫힌 글자가 있다면
                return 2 * calculateBracket(insert.substring(0, i));
            } else if (insert.charAt(0) == '[' && insert.charAt(i) == ']') {
                return 3 * calculateBracket(insert.substring(0,i));
            }
        }
        //없으면 올바르지 못한 괄호열


        return 0;
    }
}
