package programmers.stack;

import java.util.*;

public class Truck {
    public static void main(String[] args) {
        int bridge_length =
                100;
//                100;
//        2;
        int weight =
                100;
//                100;
//        10;
        int[] truck_weights = new int[]{
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10
//                10
//                7, 4, 5, 6
        };
        int result = solution2(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> pendingTruckQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();

        int bridgeWeightSum = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        for (int truck : truck_weights) {
            pendingTruckQueue.add(truck);
        }

        while (pendingTruckQueue.size() != 0 && bridgeQueue.size() != 0) {
            Integer out = bridgeQueue.poll();

            if (out != null) bridgeWeightSum -= out;

            if (pendingTruckQueue.size() > 0) {
                int pending = pendingTruckQueue.peek();

                if (bridgeWeightSum + pending <= weight) {
                    pendingTruckQueue.poll();
                    bridgeQueue.offer(pending);
                    bridgeWeightSum += pending;
                } else {
                    bridgeQueue.offer(0);
                }
            }

            time++;
        }

        return time + bridgeQueue.size();
    }

    private static int solution2(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> pendingTruckQueue = new LinkedList<>();
        Bridge bridge = new Bridge(weight, bridge_length);

        for (int truck : truck_weights) {
            pendingTruckQueue.add(truck);
        }

        return bridge.cross(pendingTruckQueue);
    }

    static class Bridge {
        int maxWeight, length;
        int weightSum = 0;

        Queue<Integer> bridgeQueue;

        Bridge(int maxWeight, int length) {
            this.maxWeight = maxWeight;
            this.length = length;
            bridgeQueue = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                bridgeQueue.offer(0);
            }
        }

        public int cross(Queue<Integer> pendingTruckQueue) {
            int time = 0;
            while (isCrossing() && !pendingTruckQueue.isEmpty()) {
                crossed();
                enter(pendingTruckQueue);
                time++;
            }
            return time + bridgeQueue.size();
        }

        private boolean isCrossing() {
            return bridgeQueue.size() > 0;
        }

        private boolean enableToCross(int weight) {
            return weightSum + weight <= maxWeight;
        }

        private void enter(Queue<Integer> pending) {
            if (pending.isEmpty()) return;

            int enterWeight = pending.peek();

            if (enableToCross(enterWeight)) {
                pending.poll();
                bridgeQueue.offer(enterWeight);
                weightSum += enterWeight;
            } else {
                bridgeQueue.offer(0);
            }
        }

        private void crossed() {
            Integer out = bridgeQueue.poll();
            if (out != null) weightSum -= out;
        }
    }
}
