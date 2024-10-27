package Simulation;

import java.util.*;

import java.util.*;

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        double answer = 0; // 자카드 유사도는 실수라고 했기 때문에
        
        str1 = str1.toUpperCase(); 
        str2 = str2.toUpperCase(); 
        
        List<String> list = new ArrayList<>(); 
        List<String> list2 = new ArrayList<>(); 
        for(int i = 0; i < str1.length() - 1; i++) {
            char c = str1.charAt(i);
            char c2 = str1.charAt(i +1);
            
            if(c >= 'A' && c <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                list.add(c + "" + c2);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            char c = str2.charAt(i);
            char c2 = str2.charAt(i +1);
            
            if(c >= 'A' && c <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                list2.add(c + "" + c2);
            }
        }
        
        Collections.sort(list); 
        Collections.sort(list2); 
        
        List<String> intersection = new ArrayList<>(); 
        List<String> union = new ArrayList<>();
        for(String s : list) {
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s); 
        }
        
        for(String s : list2) {
            union.add(s);
        }
        
        if(list.size() == 0 && list2.size() == 0) { // 둘 다 공집합인 경우 
            answer = 1;
        } else {
            answer = (double) intersection.size() / union.size();
        }
        
        return (int) (answer * 65536);
    }
}
