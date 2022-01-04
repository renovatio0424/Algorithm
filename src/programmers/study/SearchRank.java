package programmers.study;

import java.util.ArrayList;
import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/72412
public class SearchRank {
    public static void main(String[] args) {
        String[] info = new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] result = solution(info, query);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] info, String[] query) {
        ArrayList<Applicant> applicants = new ArrayList<>();

        for (String information : info) {
            applicants.add(parseInformation(information));
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String queryElement = query[i];
            String[] queryArr = queryElement.replace(" and ", " ").split(" ");

            for (Applicant applicant : applicants) {
                if (isValidApplicant(applicant, queryArr)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String information : info) {
            Applicant applicant = parseInformation(information);

            for (int i = 0; i < query.length; i++) {
                String queryElement = query[i];
                String[] queryArr = queryElement.replace(" and ", " ").split(" ");

                if (isValidApplicant(applicant, queryArr)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static int[] solution3(String[] info, String[] query) {
        int[] answer = new int[query.length];

        ArrayList<Applicant> applicants = new ArrayList<>();
        ArrayList<String[]> queryList = new ArrayList<>();

        for (String information : info) {
            applicants.add(parseInformation(information));
        }

        for (String queryElement : query) {
            String[] queryArr = queryElement.replace(" and ", " ").split(" ");
            queryList.add(queryArr);
        }

        for (int i = 0; i < queryList.size(); i++) {
            String[] queryArr = queryList.get(i);
            for (Applicant applicant : applicants) {
                if (isValidApplicant(applicant, queryArr)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    private static boolean isValidApplicant(Applicant applicant, String[] queryArr) {
        return (queryArr[0].equals("-") || queryArr[0].equals(applicant.language)) &&
                (queryArr[1].equals("-") || queryArr[1].equals(applicant.job)) &&
                (queryArr[2].equals("-") || queryArr[2].equals(applicant.career)) &&
                (queryArr[3].equals("-") || queryArr[3].equals(applicant.soulFood)) &&
                (applicant.score >= Integer.parseInt(queryArr[4]));
    }

    private static Applicant parseInformation(String information) {
        String[] parseInfo = information.split(" ");

        return new Applicant(parseInfo[0], parseInfo[1], parseInfo[2], parseInfo[3], Integer.parseInt(parseInfo[4]));
    }

    static class Applicant {
        private String language;
        private String job;
        private String career;
        private String soulFood;
        private int score;

        Applicant(String language, String job, String career, String soulFood, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }
    }
}
