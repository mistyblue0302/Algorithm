import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length]; //7 3 9
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }
            days[i] = day;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < days.length; i++){
            int count = 1;
            if(days[i] < 0) {
                continue;
            }
            for(int j = i+1; j < days.length; j++){
                if(days[i] >= days[j]) {
                    days[j] = -1;
                    count++;
                } else {
                    break;
                }
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
