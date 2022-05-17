package Test;

import java.util.List;

public class KakaoStyle1 {
    public static void main(String[] args) {

    }

    public static String findNumber(List<Integer> arr, int k) {
        if (arr.contains(k)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
