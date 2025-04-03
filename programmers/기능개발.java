import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>(); // 2
        
        int[] days = new int[progresses.length]; // 7 3 9
        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = (100 - progresses[i]) / speeds[i]; 
            } else {
                days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
        }
        
        int current = days[0]; // 9
        int count = 1; // 1
        for(int i = 1; i < days.length; i++) {
            if(current < days[i]) {
                list.add(count);
                current = days[i];
                count = 1;
            } else {
                count++;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
