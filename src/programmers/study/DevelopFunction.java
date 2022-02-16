package programmers.study;

import java.util.*;

public class DevelopFunction {
    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99/*93, 30, 55*/};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1/*1, 30, 5*/};
        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remainQueue = new LinkedList<>();
        Queue<Integer> workQueue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        //1
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int remainDay = remainProgress / speeds[i] + (remainProgress % speeds[i] == 0 ? 0 : 1);
            remainQueue.add(remainDay);
        }

        while (!remainQueue.isEmpty()) {
            int remainDay = remainQueue.poll();
            //2
            if (workQueue.isEmpty()) {
                workQueue.add(remainDay);
                continue;
            }

            int workDay = workQueue.peek();
            //3
            if (remainDay <= workDay) {
                workQueue.add(remainDay);
            }
            //4
            else {
                result.add(workQueue.size());
                workQueue.clear();
                workQueue.add(remainDay);
            }
        }
        //5
        if (!workQueue.isEmpty()) {
            result.add(workQueue.size());
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
