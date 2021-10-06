package this_is_coding_test.greedy;


/**
 * 이것이 코딩 테스트다
 * 그리디 유형 1
 * <p>
 * 거스름돈
 * 문제
 * <p>
 * 당신은 음식점의 계산을 도와주는 점이다.
 * 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
 * 손님에게 거슬러 줘야할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라.
 * 단, 거슬러 줘야할 돈 N은 항상 10의 배수이다.
 */

public class Change {
    public static void main(String[] args) {
        int N = 1260;
        int n = getMinimumChange(N);
        System.out.println(n);
    }

    private static int getMinimumChange(int change) {
        int[] coinArr = new int[]{500, 100, 50, 10};
        int count = 0;
        int remain = change;

        for (int coin : coinArr) {
            count += remain / coin;
            remain %= coin;
        }

        return count;
    }
}
