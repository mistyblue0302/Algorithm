package BF;

public class 프렌즈4블록 {

    static char[][] array;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        array = new char[m][n];

        for (int i = 0; i < m; i++) {
            array[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] visited = new boolean[m][n];

            //블록을 체크하고 일치하는 블록 표시
            for (int row = 0; row < m - 1; row++) {
                for (int col = 0; col < n - 1; col++) {
                    char ch = array[row][col];
                    if (array[row + 1][col] == ch && array[row][col + 1] == ch
                        && array[row + 1][col + 1] == ch) {
                        visited[row + 1][col] = true;
                        visited[row][col + 1] = true;
                        visited[row + 1][col + 1] = true;
                        visited[row][col] = true;
                    }
                }
            }

            //일치하는 블록 수 세고 지우기
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] && array[i][j] != '-') {
                        count++;
                        array[i][j] = '-';
                    }
                }
            }

            //일치하는 블록이 없으면 종료
            if (count == 0) {
                break;
            }

            //블록 내리기
            for (int row = m - 1; row >= 0; row--) {
                for (int col = 0; col < n; col++) {
                    if (array[row][col] != '-') {
                        continue;
                    }
                    for (int k = row - 1; k >= 0; k--) {
                        if (array[k][col] != '-') {
                            array[row][col] = array[k][col];
                            array[k][col] = '-';
                            break;
                        }
                    }
                }
            }
            answer += count;
        }

        return answer;
    }
}
