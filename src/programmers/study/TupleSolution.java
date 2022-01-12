package programmers.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TupleSolution {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = solution(s);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        //}} remove
        sb.deleteCharAt(s.length() - 1);
        sb.deleteCharAt(s.length() - 2);
        //{{ remove
        sb.deleteCharAt(0);
        sb.deleteCharAt(0);

        //"2},{2,1},{2,1,3},{2,1,3,4"
        //},{
        //[2],[2,1],[2,1,3],[2,1,3,4]
        String[] elementArr = sb.toString().split("\\}\\,\\{");
        ArrayList<Tuple> tuples = parseTuple(elementArr);
        Collections.sort(tuples);
        return findResult(tuples);
    }

    private static int[] findResult(ArrayList<Tuple> tuples) {
        int[] result = new int[tuples.size()];
        HashSet<Integer> elementSet = new HashSet<>();

        for (int i = 0; i < tuples.size(); i++) {
            if (i == 0) {
                int element = tuples.get(0).elements[0];
                result[0] = element;
                elementSet.add(element);
                continue;
            }
            for (int j = 0; j < tuples.get(i).elements.length; j++) {
                int element = tuples.get(i).elements[j];
                if (!elementSet.add(element)) {
                    result[i] = element;
                }
            }
        }
        return result;
    }

    private static ArrayList<Tuple> parseTuple(String[] elementArr) {
        ArrayList<Tuple> result = new ArrayList<>();

        for (String element : elementArr) {
            String[] numbers = element.split(",");
            int[] numberArr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numberArr[i] = Integer.parseInt(numbers[i]);
            }
            result.add(new Tuple(numberArr));
        }

        return result;
    }

    static class Tuple implements Comparable<Tuple> {
        int[] elements;

        Tuple(int[] elements) {
            this.elements = elements;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.elements.length - o.elements.length;
        }
    }
}
