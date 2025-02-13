import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String[] s = clothes[i]; 
            String name = s[0];
            String kind = s[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1); 
        }
        
        for(Integer a : map.values()) {
            answer *= (a + 1);
        }
        
        return answer - 1;
    }
}
