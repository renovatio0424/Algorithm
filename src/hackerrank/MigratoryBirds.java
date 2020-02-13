package hackerrank;

import java.util.*;

public class MigratoryBirds {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList();

        arr.add(1);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(5);
        arr.add(3);

        // 각 타입 별로 몇번씩 겹쳤는지 카운트
        HashMap<Integer,Integer> typeMap = new HashMap<>();

        for (int birdType : arr) {
            if(typeMap.containsKey(birdType)){
                int beforeCount = typeMap.get(birdType);
                typeMap.put(birdType, ++beforeCount);
            } else
                typeMap.put(birdType, 1);
        }

        // 카운트 수가 2보다 크고 가장 큰 수 선택
        int result =  Collections.max(typeMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println(result);
    }
}
