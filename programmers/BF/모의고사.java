import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] result = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if(first[i % 5] == answers[i]) result[0]++;
            if(second[i % 8] == answers[i]) result[1]++;
            if(third[i % 10] == answers[i]) result[2]++;
        }
        
        int max = Math.max(result[0], Math.max(result[1], result[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < result.length; i++) {
            if(max == result[i]) {
                list.add(i + 1);
            }    
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
