package programmers.study;


import java.util.*;

public class ShoppingGems {
    public static void main(String[] args) {
        String[] gems = new String[]{"DIA", "EM", "EM", "RUB", "DIA"};
        int[] answer = solution3(gems);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution3(String[] gems) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int startPoint = 0;
        int length = Integer.MAX_VALUE;
        Collections.addAll(hs, gems);
        int start = 0;
        for (String gem : gems) {

            // 배열을 돌면서 hashMap 에 없다면 값을 추가해고
            // 있다면 개수를 하나 추가해준다.
            if (!hm.containsKey(gem)) hm.put(gem, 1);
            else hm.put(gem, hm.get(gem) + 1);

            // 큐에 보석을담아 준다.
            q.add(gem);

            // 큐에 첫번째 보석의 개수가 1개 를 초과한다면 startPoint 를갱신해주고 q에서 빼준다.
            while (true) {
                String temp = q.peek();
                if (hm.get(temp) > 1) {
                    hm.put(temp, hm.get(temp) - 1);
                    q.poll();
                    startPoint++;
                } else {
                    break;
                }
            }
            // 만약 현재 큐에있는 보석이 모든 보석을 포함한하고(hm 의 크기와 hs 에 크기가 같다면)
            // 새로구한 구간이 현재 구간의 길이보다 작다면 최종 시작포인트 값인 start 값을 갱신해준다.
            if (hm.size() == hs.size() && length > q.size()) {
                length = q.size();
                start = startPoint;
            }
        }
        return new int[]{start + 1, start + length};
    }

    private static int[] solution2(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        int total = gems.length;
        int left = 0;
        int right = 0;

        int start = 0;
        int end = 0;

        int distance = Integer.MAX_VALUE;

        while (true) {
            if (set.size() == map.size()) {
                //크기 같은 경우 원하는 범위 좁히기
                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (total != right) {
                break;
            } else {
                //right 오른쪽으로 이동
                //set에 해당하는 보석들을 다 찾아야함
                //해당 보석의 개수 +1
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == set.size()) {
                if (right - left < distance) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }//while

        return new int[]{start, end};
    }

    static class Range implements Comparable<Range> {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getRangeLength() {
            return end - start;
        }

        @Override
        public int compareTo(Range o) {
            return Integer.compare(getRangeLength(), o.getRangeLength());
        }
    }

    private static int[] solution(String[] gems) {
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int total = gemSet.size();

        HashMap<String, Integer> gemMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if (gemMap.size() == total) break;

            String gem = gems[i];
            gemMap.put(gem, i);
        }

        List<Map.Entry<String, Integer>> gemList = new ArrayList<>(gemMap.entrySet());
        gemList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return new int[]{gemList.get(0).getValue() + 1, gemList.get(gemList.size() - 1).getValue() + 1};
    }
}
