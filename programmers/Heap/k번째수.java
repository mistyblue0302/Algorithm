package Heap;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i]; 
            int start = command[0] - 1; 
            int end = command[1]; // copyOfRange는 end 인덱스를 포함하지 않는다.
            int index = command[2] - 1;
            
            int[] copy = Arrays.copyOfRange(array, start, end);
            Arrays.sort(copy);
            answer[i] = copy[index];
        }
        return answer;
    }
}
