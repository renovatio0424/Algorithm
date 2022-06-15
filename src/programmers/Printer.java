package programmers;

import java.util.ArrayList;

public class Printer {
    public static void main(String[] args) {
//        ex1
//        int[] priorities = new int[]{
//                2, 1, 3, 2
//        };
//        int location = 2;

        //ex2
        int[] priorities = new int[]{
                //2, 1, 3, 2
                1,1,9,1,1,1
        };
        int location = 0;//2;
        int result = solution(priorities, location);
        System.out.println(result);
    }

    private static int solution(int[] priorities, int location) {
        ArrayList<Document> documentList = createDocumentList(priorities);

        ArrayList<Document> resultList = makePrintResultList(documentList);

        return findDocument(resultList, location);

    }

    private static int findDocument(ArrayList<Document> documents, int location) {
        for (int i = 0; i < documents.size(); i++) {
            Document current = documents.get(i);

            if (current.location == location) return i + 1;
        }

        return 0;
    }

    private static ArrayList<Document> makePrintResultList(ArrayList<Document> documentList) {
        ArrayList<Document> resultList = new ArrayList<>();

        while (documentList.size() != 0) {
            Document current = documentList.get(0);
            documentList.remove(0);

            if (isContainHigherPriority(current.priority, documentList)) {
                documentList.add(documentList.size(), current);
            } else {
                resultList.add(current);
            }
        }

        return resultList;
    }

    private static boolean isContainHigherPriority(int priority, ArrayList<Document> documentList) {
        for (Document document : documentList) {
            if (document.priority > priority) {
                return true;
            }
        }

        return false;
    }

    private static ArrayList<Document> createDocumentList(int[] priorities) {
        ArrayList<Document> resultList = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            resultList.add(new Document(i, priorities[i]));
        }
        return resultList;
    }

    public static class Document {
        int location;
        int priority;

        Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
