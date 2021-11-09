package programmers.kakao21_blind;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuRenewal {
    public static void main(String[] args) {

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int courseCount : course) {
            HashMap<String, Integer> menuMap = new HashMap<>();
            getMenuList(orders, courseCount, menuMap);
        }

        return answer;
    }

    private static void getMenuList(String[] orders, int courseCount, HashMap<String, Integer> menuMap) {
        ArrayList<String> menuList = new ArrayList<>();

        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                for (int j = i + 1; j < order.length(); j++) {

                }
            }
        }

    }
}
