package programmers.study;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/81303
public class EditTable {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String result = solution(n, k, cmd);
        System.out.println(result);
    }

    private static String solution(int n, int k, String[] cmd) {
        EditAction[] actionArr = parseCmd(cmd);
        return editTable(n, k, actionArr);
    }

    private static String editTable(int n, int k, EditAction[] actionArr) {
        int selected = k;
        int total = n;
        Stack<Integer> removedStack = new Stack<>();

        for (EditAction editAction : actionArr) {
            String action = editAction.action;
            if (action.equals("U")) {
                selected -= editAction.index;
            } else if (action.equals("D")) {
                selected += editAction.index;
            } else if (action.equals("C")) {
                removedStack.add(selected);
                total--;
                if (selected == total) {
                    selected--;
                }
            } else if (action.equals("Z")) {
                int lastRemoveIndex = removedStack.pop();
                if (lastRemoveIndex <= selected) {
                    selected++;
                }
                total++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("O".repeat(Math.max(0, total)));
        while(!removedStack.isEmpty())
            builder.insert(removedStack.pop(), "X");
        return builder.toString();
    }

    private static EditAction[] parseCmd(String[] cmdArr) {
        EditAction[] result = new EditAction[cmdArr.length];
        for (int i = 0; i < cmdArr.length; i++) {
            String[] splitString = cmdArr[i].split(" ");
            if (splitString.length >= 2) {
                String action = splitString[0];
                int index = Integer.parseInt(splitString[1]);
                result[i] = new EditAction(action, index);
                continue;
            }

            String action = splitString[0];
            result[i] = new EditAction(action, 0);
        }
        return result;
    }

    static class EditAction {
        String action;
        int index;

        EditAction(String action, int index) {
            this.action = action;
            this.index = index;
        }
    }
}
