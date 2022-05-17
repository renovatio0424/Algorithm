package programmers.heap;

import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = new int[][]{
//                {0, 3},
//                {1, 9},
//                {2, 6}
                //모두 동시에 요청했다면?
                {0, 1},//3
                {0, 1},//3
                {0, 1}//3
        };
        int result = solution(jobs);
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<int[]> jobRequestQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        jobRequestQueue.addAll(Arrays.asList(jobs));

        PriorityQueue<Job> pendingJobQueue = new PriorityQueue<>();

        int currentTime = 0;
        int totalTime = 0;
        int totalJobCount = 0;

        Job currentJob = null;

        while (totalJobCount < jobs.length) {
            while (jobRequestQueue.size() > 0 && jobRequestQueue.peek()[0] <= currentTime) {
                int[] jobArr = jobRequestQueue.poll();
                pendingJobQueue.add(new Job(jobArr));
            }

            if (currentJob == null && pendingJobQueue.size() > 0) {
                currentJob = pendingJobQueue.poll();
            }

            if (currentJob != null && !currentJob.isRunning(currentTime)) {
                totalTime += currentJob.getTotalTime();
                currentJob = pendingJobQueue.poll();
                if (currentJob != null) currentJob.start = currentTime;
                totalJobCount++;
            }

            currentTime++;
        }

        return Math.floorDiv(totalTime, jobs.length);
    }

    public static class Job implements Comparable<Job> {
        int request;
        int duration;
        int start;

        Job(int[] jobArr) {
            this.request = jobArr[0];
            this.duration = jobArr[1];
            this.start = 0;
        }

        @Override
        public int compareTo(Job o) {
            return this.duration - o.duration;
        }

        public boolean isRunning(int time) {
            return start + duration > time;
        }

        public int getTotalTime() {
            return start - request + duration;
        }

    }
}
