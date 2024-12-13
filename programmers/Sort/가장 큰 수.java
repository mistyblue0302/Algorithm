import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        
        // 이어 붙였을 때 가장 큰수가 먼저 나오도록 내림차순
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for(String str : s) {
            sb.append(str);
        }
        
        if(s[0].equals("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}
