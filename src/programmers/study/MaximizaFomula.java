package programmers.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximizaFomula {
    static long max = 0;

    public static void main(String[] args) {
        String expression = "50*6-3*2";//"100-200*300-500+20";
        long result = solution(expression);
        System.out.println(result);
    }


    //1. 연산자 종류를 구한다 (1,2)
    //2. 연산자 우선순위를 정한다
    //3. 우선 순위 대로 계산하고 최대값을 저장한다
    private static long solution(String expression) {
        dfs(expression, new ArrayList<String>(), 0, 3);
        return max;
    }

    private static void dfs(String expression, ArrayList<String> operatorList, int start, int end) {
        if (start == end) {
            calculate2(expression, operatorList);
            return;
        }

        if (!operatorList.contains("+")) {
            operatorList.add("+");
        }

        if (!operatorList.contains("-")) {
            operatorList.add("-");
        }

        if (!operatorList.contains("*")) {
            operatorList.add("*");
        }

        dfs(expression, operatorList, start + 1, end);
    }

    private static void calculate2(String expression, ArrayList<String> operatorArr) {
        String[] numberArr = expression.split("\\+|\\-|\\*");
        String[] opArr = expression.split("\\d+");

        ArrayList<String> numberList = new ArrayList<>(Arrays.asList(numberArr));
        ArrayList<String> opList = new ArrayList<>(Arrays.asList(opArr));
        opList.remove(0);

        for (String operator : operatorArr) {
            while (opList.contains(operator)) {
                int idx = opList.indexOf(operator);

                long arg2 = Long.parseLong(numberList.get(idx + 1));
                long arg1 = Long.parseLong(numberList.get(idx));

                numberList.remove(idx);
                numberList.remove(idx + 1);

                opList.remove(idx);
                long result;

                if (operator.equals("+")) {
                    result = arg1 + arg2;
                } else if (operator.equals("-")) {
                    result = arg1 - arg2;
                } else {
                    result = arg1 * arg2;
                }

                numberList.add(idx, "" + result);
            }
        }

        max = Math.max(max, Long.parseLong(numberList.get(0)));
    }

    private static void calculate(String expression, Character[] operatorArr) {
        String localExpression = expression;
        // -,+,*
        for (int i = 0; i < operatorArr.length; i++) {
            String regex;
            char operator;

            if (operatorArr[i] == '+') {
                operator = '+';
                regex = "(\\d+)(?:\\+)(\\d+)";
            } else if (operatorArr[i] == '-') {
                operator = '-';
                regex = "(\\d+)(?:\\-)(\\d+)";
            } else {
                operator = '*';
                regex = "(\\d+)(?:\\*)(\\d+)";
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(localExpression);

            while (matcher.find()) {
                String matchString = matcher.group();
                String regex2;
                if (operator == '+') {
                    regex2 = "\\+";
                } else if (operator == '-') {
                    regex2 = "\\-";
                } else {
                    regex2 = "\\*";
                }
                String[] argArr = matchString.split(regex2);

                long arg1 = Long.parseLong(argArr[0]);
                long arg2 = Long.parseLong(argArr[1]);

                long result;
                if (operator == '+') {
                    result = arg1 + arg2;
                } else if (operator == '-') {
                    result = arg1 - arg2;
                } else {
                    result = arg1 * arg2;
                }
                //500-200+300
                //300+300
                //-300*-200
                localExpression = localExpression.replaceFirst(regex, "" + result);
            }
        }
        try {
            max = Math.max(max, Math.abs(Long.parseLong(localExpression)));
        } catch (NumberFormatException e) {
            if (localExpression.contains("+") || localExpression.contains("*")) {
                String positive = localExpression.replaceAll("\\-", "");
                calculate(positive, operatorArr);
                return;
            }

            StringBuffer stringBuffer = new StringBuffer(localExpression);
            stringBuffer.deleteCharAt(0);
            String[] positiveArr = stringBuffer.toString().split("\\-");
            long result = 0;
            for (String positive : positiveArr) {
                result += Long.parseLong(positive);
            }
            max = Math.max(max, result);
        }
    }

    private static void swap(Character[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
