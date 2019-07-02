/*
4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.

한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다.
만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다.
X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.
예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다.
우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다.

‘()’ 인 괄호열의 값은 2이다.
‘[]’ 인 괄호열의 값은 3이다.
‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자.  ‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로  ‘(()[[ ]])’의 괄호값은 2×11=22 이다.
그리고  ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.

여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다.

input
(()[[]])([])

output
28
*/
package dfs;

import java.util.Scanner;

public class DfsSolution3 {
    private static String bracketString;
    private static boolean[] visitedString;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracketString = scanner.nextLine();
        visitedString = new boolean[bracketString.length()];

        System.out.println(calculateBracket(0));
    }

    private static int calculateBracket(int start) {
        visitedString[start] = true;

        String remain = bracketString.substring(start, start + 2);

        if (remain.equals("()")){
            return 2;
        }
        else if (remain.equals("[]")){
            return 3;
        }

        int sum = 0;

        for (int i = start; i < bracketString.length(); i++) {
            if(!visitedString[i])

            if (bracketString.charAt(start) == '(' && (!visitedString[i] && bracketString.charAt(i) == ')')) {
                sum += 2 * calculateBracket(i);
            } else if (!visitedString[i] && bracketString.charAt(i) == '[') {
                sum += 3 * innerBracket;
            }
        }

        return sum;
    }
}
