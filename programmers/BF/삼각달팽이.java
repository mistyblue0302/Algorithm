package BF;

class 삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n+1)) / 2];
        int[][] array = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;
        for(int i = 0; i < n; i++) { //세로 -> 가로 -> 대각선 : 경우의 수가 한개씩 줄어든다.
            for(int j = i; j < n ; j++) {
                if(i % 3 == 0) { //아래
                    x++;
                } else if(i % 3 == 1) { //오른쪽
                    y++;
                } else if(i % 3 == 2) { //대각선
                    x--;
                    y--;
                }
                array[x][y] = num++;
            }
        }

        int index = 0;
        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < n ;j++) {
                if(array[i][j] == 0) {
                    break;
                }
                answer[index++] = array[i][j];
            }
        }
        return answer;
    }
}
