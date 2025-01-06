import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i]; 
            int start = command[0] - 1;
            int end = command[1];
            int num = command[2];
            
            int[] copy = Arrays.copyOfRange(array, start, end);  
            Arrays.sort(copy); 
            answer[i] = copy[num - 1];
        }
        
        return answer;
    }
}
