package dfs;


import java.util.Scanner;

/**
 * 좋은 단어
 * <p>
 * 문제
 * <p>
 * 이번 계절학기에 심리학 개론을 수강 중인 평석이는 오늘 자정까지 보고서를 제출해야 한다. 보고서 작성이 너무 지루했던 평석이는 노트북에 엎드려서 꾸벅꾸벅 졸다가 제출 마감 1시간 전에 깨고 말았다. 안타깝게도 자는 동안 키보드가 잘못 눌려서 보고서의 모든 글자가 A와 B로 바뀌어 버렸다! 그래서 평석이는 보고서 작성을 때려치우고 보고서에서 '좋은 단어'나 세보기로 마음 먹었다.
 * <p>
 * 평석이는 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 짓기로 하였다. 만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면, 그 단어는 '좋은 단어'이다. 평석이가 '좋은 단어' 개수를 세는 것을 도와주자.
 * <p>
 * 입력
 * <p>
 * 첫째 줄에 단어의 수 N이 주어진다. (1 ≤ N ≤ 100)
 * <p>
 * 다음 N개 줄에는 A와 B로만 이루어진 단어가 한 줄에 하나씩 주어진다. 단어의 길이는 2와 100,000사이이며, 모든 단어 길이의 합은 1,000,000을 넘지 않는다.
 * <p>
 * 출력
 * <p>
 * 첫째 줄에 좋은 단어의 수를 출력한다.
 * <p>
 * https://www.acmicpc.net/problem/3986
 */
public class DfsSolution2 {

    private static int goodVocaCount = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCase; i++) {
            if (isGoodVoca(scanner.nextLine()))
                goodVocaCount++;

        }

        System.out.println(goodVocaCount + "");
    }

    private static boolean isGoodVoca(String voca) throws Exception {
        if (voca.length() < 1)
            return false;

        if (voca.length() == 2) {
            return voca.charAt(0) == voca.charAt(1);
        }

        int sameIndex = voca.substring(1).indexOf(voca.charAt(0)) + 1;

        if(sameIndex == 0)
            return false;

        //첫글자와 같은 글자가 바로 옆에 있을때
        if (sameIndex == 1)
            return isGoodVoca(voca.substring(2));
        //첫글자랑 같은 글자가 마지막 글자가 아닐때
        else if (sameIndex != voca.length() - 1)
            //첫글자와 같은 글자 사이의 문자열이 좋은 단어 이면서 나머지 문자열이 좋은 단어이면 좋은 단어이다.
            return isGoodVoca(voca.substring(1, sameIndex - 1)) && isGoodVoca(voca.substring(sameIndex + 1));
        //첫글자랑 같은 글자가 마지막 글자일때
        else
            return isGoodVoca(voca.substring(1, sameIndex));
    }

}
