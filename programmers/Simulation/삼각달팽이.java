package Simulation;

class 삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] array = new int[n][n];

        int x = -1, y = 0, start = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                array[x][y] = start++;
            }
        }

        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] == 0) {
                    continue;
                }
                answer[index++] = array[i][j];
            }
        }
        return answer;
    }
}
