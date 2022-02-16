package programmers.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GetReportResult {
    public static void main(String[] args) {
        String[] id_list = new String[]{"con", "ryan"};
        String[] report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        int[] result = solution(id_list, report, k);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] resultArr = new int[id_list.length];
        ReportTable reportTable = new ReportTable();

        for (String reportElement: report) {
            String[] reportArr = reportElement.split(" ");
            String reporter = reportArr[0];
            String reported = reportArr[1];

            reportTable.addReported(reporter, reported);
        }

        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            resultArr[i] = reportTable.getReportCount(reporter, k);
        }
        return resultArr;
    }

    static class ReportTable {
        private HashMap<String, HashSet<String>> reporterMap;
        private HashMap<String, Integer> reportedCountMap;

        ReportTable() {
            reporterMap = new HashMap<>();
            reportedCountMap = new HashMap<>();
        }

        public void addReported(String reporter, String reported) {
            HashSet<String> reportedSet;
            // 신고한 유저가 신고한 적이 있는지
            if (reporterMap.containsKey(reporter)) {
                reportedSet = reporterMap.get(reporter);
                if (reportedSet.add(reported)) {
                    //신고 당한 유저가 처음 신고된 경우라면
                    if (reportedCountMap.containsKey(reported)) {
                        int count = reportedCountMap.get(reported);
                        reportedCountMap.put(reported, count + 1);
                    } else {
                        reportedCountMap.put(reported, 1);
                    }
                }
            }
            // 신고한 유저가 처음으로 신고하는지
            else {
                reportedSet = new HashSet<>();
                if (reportedSet.add(reported)) {
                    //신고 당한 유저가 처음 신고된 경우라면
                    if (reportedCountMap.containsKey(reported)) {
                        int count = reportedCountMap.get(reported);
                        reportedCountMap.put(reported, count + 1);
                    } else {
                        reportedCountMap.put(reported, 1);
                    }
                }
            }
            reporterMap.put(reporter, reportedSet);
        }

        public int getReportCount(String reporter, int minCount) {
            //해당 유저가 신고한 유저가 있는지
            if (!reporterMap.containsKey(reporter)) return 0;

            HashSet<String> reported = reporterMap.get(reporter);
            int reportCount = 0;
            for (String reportedPerson : reported) {
                if (!reportedCountMap.containsKey(reportedPerson)) continue;
                int count = reportedCountMap.get(reportedPerson);
                //해당 유저가 신고한 유저가 정지 횟수 이상 신고되었는지
                if (count >= minCount) reportCount++;
            }
            return reportCount;
        }
    }
}
