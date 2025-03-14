import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int index = command[2];
            
            int copyArray[] = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(copyArray);
            
            answer[i] = copyArray[index - 1];
        }

        return answer;
    }
}
