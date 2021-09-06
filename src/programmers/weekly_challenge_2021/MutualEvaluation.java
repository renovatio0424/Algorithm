package programmers.weekly_challenge_2021;

public class MutualEvaluation {
    public static void main(String[] args) {
        int[][] scores = new int[][]{
                // 1
//                {100, 90, 98, 88, 65},
//                {50, 45, 99, 85, 77},
//                {47, 88, 95, 80, 67},
//                {61, 57, 100, 80, 65},
//                {24, 90, 94, 75, 65}
                // 2
//                {50, 90},
//                {50, 87}
                // 3
                {70,49,90},
                {68,50,38},
                {73,31,100}
        };

        String result = solution(scores);
        System.out.println(result);
    }

    private static String solution(int[][] scores) {
        int[][] transScores = new int[scores.length][scores.length];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                transScores[i][j] = scores[j][i];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {
            int average = getAverage(i, transScores[i]);
            String grade = getGrade(average);
            sb.append(grade);
        }

        return sb.toString();
    }

    private static int getAverage(int idx, int[] rowScores) {
        int max = rowScores[0];
        int min = rowScores[0];
        int total = rowScores[0];
        int memberCount = rowScores.length;

        for (int i = 1; i < rowScores.length; i++) {
            max = Math.max(max, rowScores[i]);
            min = Math.min(min, rowScores[i]);
            total += rowScores[i];
        }

        if (max == rowScores[idx] || min == rowScores[idx]) {
            boolean isUnique = true;
            for (int i = 0; i < rowScores.length; i++) {
                if (i != idx && rowScores[i] == rowScores[idx]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                total -= rowScores[idx];
                memberCount--;
            }
        }

        return total / memberCount;
    }

    private static String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else
            return "F";
    }
}
