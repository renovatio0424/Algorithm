package Test;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class Line {
    public static void main(String[] args) {
//        int[][] v = new int[][]{{1, 4}, {3, 4}, {3, 10}};
//        int[] result = solution(v);
//        System.out.println(Arrays.toString(result));
//
        long currentTimestamp = 1605163143000L;
        long postTimestamp = 1605163133000L;

        String result = getTime(currentTimestamp, postTimestamp);
        System.out.println(result);
    }

    public static int[] solution(int[][] v) {
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            int x = v[i][0];
            int y = v[i][1];

            if (xList.contains(x)) {
                xList.remove((Integer) x);
            } else {
                xList.add(x);
            }

            if (yList.contains(y)) {
                yList.remove((Integer) y);
            } else {
                yList.add(y);
            }
        }

        return new int[]{xList.get(0), yList.get(0)};
    }

    public static String getTime(long current, long post) {
        Calendar currentDay = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
        currentDay.setTimeInMillis(current);

        Calendar postDay = Calendar.getInstance();
        postDay.setTimeInMillis(post);

        currentDay.get(Calendar.YEAR);
        currentDay.get(Calendar.MONTH);
        currentDay.getTimeInMillis();
        return "";
    }
}

