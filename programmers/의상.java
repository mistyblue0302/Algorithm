import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
           String cloth = clothes[i][1];
            map.put(cloth, map.getOrDefault(cloth, 0) + 1);
        }
        
        for(String s : map.keySet()) {
            answer *= (map.get(s) + 1);
        }
        
        return answer - 1;
    }
}
