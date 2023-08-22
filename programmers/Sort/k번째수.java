package Sort;

import java.util.*;

class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = commands[i]; //253
            int[] arr = Arrays.copyOfRange(array, temp[0] - 1, temp[1]);
            Arrays.sort(arr);
            answer[i] = arr[temp[2] - 1];
        }
        return answer;
    }
}
