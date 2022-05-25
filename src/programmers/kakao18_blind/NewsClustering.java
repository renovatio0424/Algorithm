package programmers.kakao18_blind;

import java.util.ArrayList;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        int result = solution(str1, str2);
        System.out.println(result);
    }

    private static int solution(String str1, String str2) {
        ArrayList<String> multipleSetArr1 = getMultipleSet(str1);
        ArrayList<String> multipleSetArr2 = getMultipleSet(str2);
        float similarity = calculateJacquardSimilarity(multipleSetArr1, multipleSetArr2);
        return (int) (similarity * 65536);
    }

    private static float calculateJacquardSimilarity(ArrayList<String> multipleSetArr1, ArrayList<String> multipleSetArr2) {
        ArrayList<String> setList1 = new ArrayList<>(multipleSetArr1);
        ArrayList<String> setList2 = new ArrayList<>(multipleSetArr2);

        //교집합
        ArrayList<String> intersection = new ArrayList<>();
        //합집합
        ArrayList<String> aggregation = new ArrayList<>(setList2);

        for (String element : setList1) {
            int idx = setList2.indexOf(element);
            //중복
            if (idx != -1) {
                intersection.add(element);
                setList2.remove(idx);
            }
            aggregation.add(element);
        }

        for (String same : intersection) {
            aggregation.remove(same);
        }

        if (aggregation.size() == 0) return 1;

        return ((float) intersection.size() / aggregation.size());
    }

    private static ArrayList<String> getMultipleSet(String str1) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String stringPair = str1.substring(i, i + 2);
            if (stringPair.matches("^[a-zA-Z]*$")) {
                result.add(stringPair.toUpperCase());
            }
        }
        return result;
    }
}
