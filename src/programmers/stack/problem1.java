package programmers.stack;

import java.util.LinkedList;
import java.util.Queue;

public class problem1 {
    public static void main(String[] args) {
        int bridge_length = 2;//100;
        int weight = 10;//100;
        int[] trucks = {7,4,5,6};//{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int time = solution(bridge_length, weight, trucks);
        System.out.println("time: " + time);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        int nextTruckIdx = truck_weights.length - 1;

        Queue<Integer> bridgeQueue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        while (bridgeQueue.peek() != null && bridgeQueue.peek() != truck_weights[0] || nextTruckIdx != -1 || totalWeight != 0) {
            Integer crossed = bridgeQueue.poll();
            if (crossed != null) {
                totalWeight -= crossed;
            }

            if (nextTruckIdx != -1) {
                int nextWeight = truck_weights[nextTruckIdx];

                if (weight > totalWeight + nextWeight) {
                    bridgeQueue.offer(nextWeight);
                    totalWeight += nextWeight;
                    nextTruckIdx--;
                } else {
                    bridgeQueue.offer(0);
                }
            }

            time++;
        }

        return time;
    }
}
