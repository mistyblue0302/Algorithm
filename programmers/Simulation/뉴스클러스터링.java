package Simulation;

import java.util.*;

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        double answer = 0;

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if (a >= 'A' && a <= 'Z' && b >= 'A' && b <= 'Z') {
                list.add(a + "" + b);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            if (a >= 'A' && a <= 'Z' && b >= 'A' && b <= 'Z') {
                list2.add(a + "" + b);
            }
        }

        Collections.sort(list);
        Collections.sort(list2);

        for (String s : list) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        for (String s : list2) {
            union.add(s);
        }

        if (union.size() == 0) {
            answer = 1;
        } else {
            answer = (double) intersection.size() / (double) union.size();
        }
        return (int) (answer * 65536);
    }
}
