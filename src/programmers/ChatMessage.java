package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ChatMessage {
    public static void main(String[] args) {
        String[] result = solution(new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        });

        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] record) {
        String[] answer = new String[1];
        ArrayList<Chat> chatList = new ArrayList<>();

        for (String recordElement: record) {
            Chat newChat = new Chat(recordElement);
            chatList.add(newChat);
        }

        HashMap<String, Chat> changeUid = new HashMap();
        changeUid.put("asd", new Chat("asdasd"));
        changeUid.containsKey("");
        for (String uid : changeUid.keySet()) {

        }
        return answer;
    }

    public static class Chat {
        String action;
        String uid;
        String userName;

        Chat (String record) {
            String[] splitRecord = record.split(" ");
            action = splitRecord[0];
            uid = splitRecord[1];
            if (!action.equals("Leave")) {
                userName = splitRecord[2];
            }
        }



        @Override
        public String toString() {
            return "Chat{" +
                    "action='" + action + '\'' +
                    ", uid='" + uid + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }
}
