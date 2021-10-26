package programmers.level2;

import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {
        String input = "(()(";

        boolean result = solution(input);

        System.out.println(result);
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(current);
                continue;
            }

            char previous = stack.peek();

            if (previous == '(' && current == ')') {
                stack.pop();
                continue;
            } else {
                stack.add(current);
            }


        }

        return stack.size() == 0;
    }
}
