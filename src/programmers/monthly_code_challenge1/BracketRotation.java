package programmers.monthly_code_challenge1;

import java.util.Stack;

public class BracketRotation {
    public static void main(String[] args) {
        String s = "}}}";

        int result = solution(s);

        System.out.println("result: " + result);
    }

    private static int solution(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotatedBracket = rotateBracket(s, i);
            boolean isCorrectedBracket = isCorrectBracket(rotatedBracket);
            if (isCorrectedBracket) sum++;
        }

        return sum;
    }

    private static boolean isCorrectBracket(String rotatedBracket) {
        Stack<Character> bracketStack = new Stack<>();

        for (char bracket : rotatedBracket.toCharArray()) {
            if (bracketStack.isEmpty()) {
                bracketStack.push(bracket);
                continue;
            }

            char prevBracket = bracketStack.peek();

            if (prevBracket == '(' && bracket == ')' || prevBracket == '[' && bracket == ']' || prevBracket == '{' && bracket == '}') {
                bracketStack.pop();
            } else {
                bracketStack.push(bracket);
            }
        }

        return bracketStack.isEmpty();
    }

    // i = 0 ~ s.length - 1
    private static String rotateBracket(String s, int i) {
        String rotate = s.substring(0, i);
        String origin = s.substring(i);
        return origin + rotate;
    }
}
