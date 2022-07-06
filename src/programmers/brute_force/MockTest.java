package programmers.brute_force;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
    public static void main(String[] args) {
        int[] answer = new int[]{
                //1, 2, 3, 4, 5
                1, 3, 2, 4, 2
        };
        int[] result = solution(answer);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] answer) {
        Solver solver1 = new SolverImpl(new int[]{1, 2, 3, 4, 5});
        Solver solver2 = new SolverImpl(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Solver solver3 = new SolverImpl(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int[] answerCountArr = new int[]{solver1.getCorrectCount(answer), solver2.getCorrectCount(answer), solver3.getCorrectCount(answer)};

        return findMaxIndexArr(answerCountArr);
    }

    private static int[] findMaxIndexArr(int[] answerCountArr) {
        int max = 0;
        for (int j : answerCountArr) {
            max = Math.max(max, j);
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < answerCountArr.length; i++) {
            if (answerCountArr[i] == max) {
                resultList.add(i + 1);
            }
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}

class SolverImpl implements Solver {
    int[] answerPatternArr;

    SolverImpl(int[] answerPatternArr) {
        this.answerPatternArr = answerPatternArr;
    }

    @Override
    public int getCorrectCount(int[] answer) {
        int correctCount = 0;
        int answerTotal = answerPatternArr.length;
        for (int i = 0; i < answer.length; i++) {
            if (answerPatternArr[i % answerTotal] == answer[i]) correctCount++;
        }
        return correctCount;
    }
}

interface Solver {
    int getCorrectCount(int[] answer);
}
