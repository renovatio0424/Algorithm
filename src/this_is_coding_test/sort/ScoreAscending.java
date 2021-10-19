package this_is_coding_test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreAscending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Score> scoreList = new ArrayList<>();

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            scoreList.add(new Score(inputArr[0], Integer.parseInt(inputArr[1])));
        }

        Collections.sort(scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o1.score - o2.score;
            }
        });

        for (Score score : scoreList) {
            System.out.print(score.name + " ");
        }
    }

    static class Score {
        public String name;
        public int score;

        Score(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
