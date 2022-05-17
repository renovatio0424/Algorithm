package programmers.kakao19;

import java.util.*;

public class FailRate {
    public static void main(String[] args) {
//        int n = 5;
//        int[] stages = new int[]{
//                2, 1, 2, 6, 2, 4, 3, 3
//        };
        int n = 4;
        int[] stages = new int[]{
                4,4,4,4,4
        };
        int[] result = solution(n, stages);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Stage> stageMap = new HashMap<>();
        int total = stages.length;
        int[] answer = new int[N];

        for (int i = 1; i < N + 1; i++) {
            stageMap.put(i, new Stage(i, 0));
        }

        for (int stage : stages) {
            if (stageMap.containsKey(stage)) {
                Stage stage1 = stageMap.get(stage);
                stage1.failCount++;
            }
        }

        Object[] keySet = stageMap.keySet().toArray();
        Arrays.sort(keySet);

        for (int i = 0; i < keySet.length; i++) {
            int stage = (int) keySet[i];
            Stage current;
            if (stageMap.containsKey(stage)) {
                current = stageMap.get(stage);
                current.total = total;
                total -= current.failCount;
            }
        }

        List<Map.Entry<Integer, Stage>> failList = new ArrayList<>(stageMap.entrySet());
        Collections.sort(failList, new Comparator<Map.Entry<Integer, Stage>>() {
            @Override
            public int compare(Map.Entry<Integer, Stage> o1, Map.Entry<Integer, Stage> o2) {
                float diff = o2.getValue().calculateFailRate() - o1.getValue().calculateFailRate();

                if (diff > 0) {
                    return 1;
                } else if (diff < 0) {
                    return -1;
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });

        for (int i = 0; i < failList.size(); i++) {
            answer[i] = failList.get(i).getKey();
        }

        return answer;
    }

    public static class Stage {
        int stage;
        int failCount;
        int total;

        Stage(int stage, int failCount) {
            this.stage = stage;
            this.failCount = failCount;
        }

        public float calculateFailRate() {
            return (float) failCount / total;
        }
    }
}
