import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] s = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        
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
