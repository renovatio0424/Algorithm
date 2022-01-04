package programmers.study;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/60058
public class TransformBracket {
    public static void main(String[] args) {
        String p = "()))((()";
        String result = solution(p);
        System.out.println(result);
    }

    public static String solution(String p) {
        if (isCorrectBracket(p)) {
            return p;
        }

        int idx = findBalancedIdx(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        if (isCorrectBracket(u)) {
            return u + solution(v);
        }

        return transformBracket(u, v);
    }

    public static int findBalancedIdx(String w) {
        if (w.isEmpty()) return 0;

        int bracket1Count = 0;
        int bracket2Count = 0;

        for (int i = 0; i < w.length(); i++) {
            char bracket = w.charAt(i);
            if (bracket == '(') bracket1Count++;
            else if (bracket == ')') bracket2Count++;

            if (bracket1Count == bracket2Count) return i;
        }

        return w.length() - 1;
    }

    public static boolean isCorrectBracket(String bracketString) {
        Stack<Character> bracketStack = new Stack<>();

        for (char bracket : bracketString.toCharArray()) {
            if (bracketStack.isEmpty()) {
                bracketStack.push(bracket);
                continue;
            }

            char oldBracket = bracketStack.peek();
            if (oldBracket == '(' && bracket == ')') bracketStack.pop();
            else bracketStack.push(bracket);
        }

        return bracketStack.isEmpty();
    }

    public static String transformBracket(String u, String v) {
        StringBuilder result = new StringBuilder();
        result.append('(');
        result.append(solution(v));
        result.append(')');

        StringBuilder newString = new StringBuilder(u);
        newString.deleteCharAt(u.length() - 1);
        newString.deleteCharAt(0);
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == '(') result.append(')');
            else result.append('(');
        }

        return result.toString();
    }
}
