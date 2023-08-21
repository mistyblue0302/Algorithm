package BF;

import java.util.*;

class 행렬테두리회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = num++;
            }
        }
        return recursion(array, queries);
    }

    public int[] recursion(int[][] array, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] query : queries) { //2254
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int firstNum = array[x1][y2]; // 10
            int min = firstNum;
            for (int i = y2 - 1; i >= y1; i--) { //숫자를 오른쪽으로 이동
                array[x1][i + 1] = array[x1][i];
                min = Math.min(array[x1][i + 1], min); //최솟값 갱신
            }

            for (int i = x1 + 1; i <= x2; i++) { //숫자를 위로 이동
                array[i - 1][y1] = array[i][y1];
                min = Math.min(array[i - 1][y1], min);
            }

            for (int i = y1 + 1; i <= y2; i++) { //숫자를 왼쪽으로 이동
                array[x2][i - 1] = array[x2][i];
                min = Math.min(array[x2][i - 1], min);
            }

            for (int i = x2 - 1; i >= x1; i--) { //숫자를 아래로 이동
                array[i + 1][y2] = array[i][y2];
                min = Math.min(array[i + 1][y2], min);
            }
            array[x1 + 1][y2] = firstNum;
            answer[index++] = min;
        }
        return answer;
    }
}