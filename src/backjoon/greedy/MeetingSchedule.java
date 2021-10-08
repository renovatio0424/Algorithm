package backjoon.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MeetingSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<int[]> scheduleArr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            int[] schedule = new int[2];
            schedule[0] = startTime;
            schedule[1] = endTime;
            scheduleArr.add(schedule);
        }

        int result = getMaximumSchedule(scheduleArr);

        System.out.println(result);
    }

    private static int getMaximumSchedule(ArrayList<int[]> originalScheduleList) {
        ArrayList<int[]> scheduleList = new ArrayList<>();

        //회의 시간 짧은 순으로
        originalScheduleList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1])
                    return -1;
                else if (o1[1] == o2[1]) {
                    if (o1[0] < o2[0])
                        return -1;
                    else
                        return 1;
                } else
                    return 1;
            }
        });

        for (int[] schedule : originalScheduleList) {
            if (scheduleList.size() == 0)
                scheduleList.add(schedule);

            int[] lastSchedule = scheduleList.get(scheduleList.size() - 1);
            if (lastSchedule[1] <= schedule[0]) {
                scheduleList.add(schedule);
            }
        }

        return scheduleList.size();
    }
}
