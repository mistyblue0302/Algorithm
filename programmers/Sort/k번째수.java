package Sort;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            int[] command = commands[i]; // 2 5 3
            int a = command[0]; // 2
            int b = command[1]; // 5
            int c = command[2]; // 3
            for(int j = a - 1; j <= b - 1; j++) {
                int num = array[j];
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[index++] = list.get(c - 1);
        }
        return answer;
    }
}
