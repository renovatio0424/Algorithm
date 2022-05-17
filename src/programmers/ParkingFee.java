package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParkingFee {
    // custom class x
    // divide conquer
    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] result = solution(fees, records);

        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] fees, String[] records) {
        //시간별 주차기록 리스트를 차량별 주차 기록 리스트 만들기
        ArrayList<ParkingRecord> recordList = getParkingRecordList(records);
        //차량별 누적 주차 시간 리스트 만들기
        List<Map.Entry<String, Integer>> parkingTimeList = getParkingTimeList(recordList);
        //차량별 주차 요금 리스트 만들기
        return calculateParkingFee(fees, parkingTimeList);
    }

    private static int[] calculateParkingFee(int[] fees, List<Map.Entry<String, Integer>> parkingTimeList) {
        int[] result = new int[parkingTimeList.size()];
        for (int i = 0; i < parkingTimeList.size(); i++) {
            result[i] = calculateFee(parkingTimeList.get(i).getValue(), fees);
        }
        return result;
    }

    private static List<Map.Entry<String, Integer>> getParkingTimeList(ArrayList<ParkingRecord> recordList) {
        HashMap<String, Integer> parkingTimeMap = new HashMap<>();

        for (ParkingRecord record : recordList) {
            if (parkingTimeMap.containsKey(record.carNumber)) {
                int parkingTime = parkingTimeMap.get(record.carNumber);
                parkingTime += record.calculateParkingTime();
                parkingTimeMap.put(record.carNumber, parkingTime);
            } else {
                parkingTimeMap.put(record.carNumber, record.calculateParkingTime());
            }
        }
        List<Map.Entry<String, Integer>> parkingTimeList = new LinkedList<>(parkingTimeMap.entrySet());
        parkingTimeList.sort(Map.Entry.comparingByKey());
        return parkingTimeList;
    }

    private static ArrayList<ParkingRecord> getParkingRecordList(String[] records) {
        HashMap<String, ParkingRecord> parkingRecordMap = new HashMap<>();
        ArrayList<ParkingRecord> recordList = new ArrayList<>();

        for (String record : records) {
            String[] recordArr = record.split(" ");
            if (recordArr[2].equals("IN")) {
                parkingRecordMap.put(recordArr[1], new ParkingRecord(recordArr[0], recordArr[1]));
            } else if (recordArr[2].equals("OUT")) {
                ParkingRecord parkingRecord = parkingRecordMap.get(recordArr[1]);
                parkingRecord.setExitTime(recordArr[0]);
                recordList.add(parkingRecord);
                parkingRecordMap.remove(recordArr[1]);
            }
        }

        for (Map.Entry<String, ParkingRecord> entry : parkingRecordMap.entrySet()) {
            recordList.add(entry.getValue());
        }

        recordList.sort(Comparator.comparing(o -> o.carNumber));
        return recordList;
    }

    public static int calculateFee(int parkingTime, int[] fees) {
        return calculateFee(parkingTime, fees[0], fees[1], fees[2], fees[3]);
    }

    public static int calculateFee(int parkingTime, int defaultTime, int defaultFee, int timeUnit, int feeUnit) {
        int parkingFee = defaultFee;
        if (defaultTime >= parkingTime) {
            return parkingFee;
        }

        int exceedTime = (int) Math.ceil((double) (parkingTime - defaultTime) / timeUnit);
        parkingFee += exceedTime * feeUnit;
        return parkingFee;
    }

    public static class ParkingRecord {
        private String enterTime;
        private String exitTime = "23:59";
        private String carNumber;

        ParkingRecord(String enterTime, String carNumber) {
            this.enterTime = enterTime;
            this.carNumber = carNumber;
        }

        public void setExitTime(String exitTime) {
            this.exitTime = exitTime;
        }

        public int calculateParkingTime() {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date enterDate = sdf.parse(enterTime);
                Date exitDate = sdf.parse(exitTime);
                long diff = exitDate.getTime() - enterDate.getTime();
                return (int) (diff / 1000 / 60);
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    enum MediaType {
        IMAGE(new String[]{"jpg", "png"}),
        MOVIE(new String[]{"mp4"}),
        MUSIC(new String[]{"mp3", "flac"}),
        OTHER(new String[]{"txt", "exe"});

        private final String[] ext;

        MediaType(String[] ext) {
            this.ext = ext;
        }

        private String getExtension(String fileName) {
            int extIdx = fileName.lastIndexOf('.');
            return fileName.substring(extIdx, fileName.length() - 1);
        }

        private boolean isContain(MediaType mediaType, String ext) {
            for (String extElement : mediaType.ext) {
                if (extElement.equals(ext)) return true;
            }
            return false;
        }

        private boolean isMedia(MediaType mediaType, String fileName) {
            String ext = getExtension(fileName);
            return isContain(mediaType, ext);
        }

        public MediaType getMediaType(String fileName) {
            if (isMedia(IMAGE, fileName)) return IMAGE;
            else if (isMedia(MOVIE, fileName)) return MOVIE;
            else if (isMedia(MUSIC, fileName)) return MUSIC;
            else return OTHER;
        }
    }
}
