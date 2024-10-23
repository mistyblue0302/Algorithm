package Sort;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] arr = commands[i]; 
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            List<Integer> list = new ArrayList<>();
            for(int j = a - 1; j <= b - 1; j++) {
                list.add(array[j]);
            }
            Collections.sort(list); 
            answer[i] = list.get(c - 1);
        }
        return answer;
    }
}
