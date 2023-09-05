package BF;

import java.util.*;

class 모음사전 {
    static String[] arr = new String[]{"A", "E", "I", "O", "U"};;
    static List<String> list = new ArrayList<>();;

    public int solution(String word) {
        int answer = 0;
        recursion(word, "", 0);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }


    public static void recursion(String word, String str, int depth) {
        list.add(str);

        if(depth == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}
