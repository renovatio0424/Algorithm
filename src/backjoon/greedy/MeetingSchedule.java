package backjoon.greedy;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MeetingSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        CopyOnWriteArrayList<int[]> scheduleArr = new CopyOnWriteArrayList<>();

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

    private static int getMaximumSchedule(CopyOnWriteArrayList<int[]> originalScheduleArr) {
        CopyOnWriteArrayList<int[]> scheduleList = new CopyOnWriteArrayList<>();

        //회의 시간 짧은 순으로
        originalScheduleArr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o1[0] < o2[1] - o2[0])
                    return -1;
                else if (o1[1] - o1[0] == o2[1] - o2[0]) {
                    if (o1[0] < o2[0])
                        return -1;
                    else
                        return 1;
                } else
                    return 1;
            }
        });

        for (int[] schedule : originalScheduleArr) {
            if (scheduleList.size() == 0 || scheduleList.size() == 1) {
                scheduleList.add(schedule);
                originalScheduleArr.remove(schedule);
            }

            for (int i = 0; i < scheduleList.size() - 1; i++) {
                int[] scheduleElement1 = scheduleList.get(i);
                int[] scheduleElement2 = scheduleList.get(i + 1);

                if (i == 0 && scheduleElement1[0] >= schedule[1]) {
                    scheduleList.add(i, schedule);
                    originalScheduleArr.remove(schedule);
                } else if (i == scheduleList.size() - 2 && scheduleElement2[1] <= schedule[0]){
                    scheduleList.add(schedule);
                    originalScheduleArr.remove(schedule);
                } else if (scheduleElement1[1] <= schedule[0] && schedule[1] <= scheduleElement2[0]) {
                    scheduleList.add(i + 1, schedule);
                    originalScheduleArr.remove(schedule);
                }
            }
        }

        return scheduleList.size();
    }
}
