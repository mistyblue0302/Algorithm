import java.util.*;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        
        // 이어붙였을 때 큰값이 앞에 오도록 정렬됨(내림차순) 
        // [6, 2, 10]
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 만약 0밖에 원소가 없을 경우 "000" 등을 방지하기 위해
        if(s[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : s) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}
