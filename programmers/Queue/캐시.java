import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> list = new LinkedList<>();
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(int i = 0; i < cities.length; i++){
            String str = cities[i].toUpperCase();
            if(list.contains(str)) {
                list.remove(str);
                list.add(str);
                answer += 1;
            } else {
                if(cacheSize == list.size()) {
                    list.remove(0);
                    list.add(str);
                    answer += 5;
                } else {
                    list.add(str);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
