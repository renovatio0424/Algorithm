package programmers.kakao21_blind;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] orders = new String[]{
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        int[] course = new int[]{2, 3, 4};
        String[] result = solution(orders, course);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();

        //find total menu 26개
        Character[] menuArr = getTotalMenuArr(orders);

        for (int courseCount : course) {
            ArrayList<String> courseList = findAllCourseCombination(menuArr, courseCount);

            int maxContainCount = 0;
            for (String courseMenu : courseList) {
                int orderMember = countOrderMember(orders, courseMenu);
                if (orderMember >= 2 && maxContainCount < orderMember) {
                    maxContainCount = orderMember;
                    result.removeIf(resultElement -> resultElement.length() == courseCount);
                    result.add(courseMenu);
                } else if (orderMember >= 2 && maxContainCount == orderMember) {
                    result.add(courseMenu);
                }
            }
        }

        Collections.sort(result);
        String[] resultArr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    private static ArrayList<String> findAllCourseCombination(Character[] menuArr, int courseCount) {
        boolean[] visited = new boolean[menuArr.length];
        ArrayList<String> courseList = new ArrayList<>();
        combination(menuArr, visited, 0, menuArr.length, courseCount, courseList);
        return courseList;
    }

    private static Character[] getTotalMenuArr(String[] orders) {
        HashSet<Character> menuSet = new HashSet<>();
        for (String order : orders) {
            for (char menu : order.toCharArray()) {
                menuSet.add(menu);
            }
        }

        //courseList
        Character[] menuArr = new Character[menuSet.size()];
        menuSet.toArray(menuArr);
        return menuArr;
    }

    private static int countOrderMember(String[] orders, String courseMenu) {
        int orderMemberCount = 0;
        for (String order: orders) {
            int containedCourseCount = 0;
            for (char course: courseMenu.toCharArray()) {
                if (order.indexOf(course) != -1) {
                    containedCourseCount++;
                }
            }

            if (containedCourseCount == courseMenu.length()) orderMemberCount++;
        }

        return orderMemberCount;
    }

    static void combination(Character[] menuArr, boolean[] visited, int start, int n, int r, ArrayList<String> courseList) {
        if(r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(menuArr[i]);
            }
            String course = sb.toString();
            if (course.isEmpty() || course.isBlank()) return;

            courseList.add(sb.toString());
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(menuArr, visited, i + 1, n, r - 1, courseList);
            visited[i] = false;
        }
    }
}
