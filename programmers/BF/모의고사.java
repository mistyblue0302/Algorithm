import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] array = {1,2,3,4,5};
        int[] array2 = {2,1,2,3,2,4,2,5};
        int[] array3 = {3,3,1,1,2,2,4,4,5,5};
        int[] count = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if(array[i % 5] == answers[i]) count[0]++;
            if(array2[i % 8] == answers[i]) count[1]++;
            if(array3[i % 10] == answers[i]) count[2]++;
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count.length; i++) {
            if(max == count[i]) {
                list.add(i + 1);
            }    
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
