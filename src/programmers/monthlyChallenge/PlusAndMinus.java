package programmers.monthlyChallenge;

/**
 * @link: https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class PlusAndMinus {
    public static void main(String[] args) {
        int[] absolutes = new int[]{4, 7, 12};
        boolean[] signs = new boolean[]{true, false, true};

        int result = solution(absolutes, signs);

        System.out.println("result : " + result);
    }

    private static int solution(int[] absolutes, boolean[] signs) {
        int plusSum = 0;
        int minusSum = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                plusSum += absolutes[i];
            } else {
                minusSum += absolutes[i];
            }
        }

        return plusSum - minusSum;
    }
}
