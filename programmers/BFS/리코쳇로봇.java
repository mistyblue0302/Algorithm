package BFS;

import java.util.*;

class 리코쳇로봇 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] array;
    static boolean[][] visited;
    static int row, col;
    static int firstX, firstY;
    static int resultX, resultY;
    static Queue<int[]> queue = new LinkedList<>();
    static int answer;

    public int solution(String[] board) {
        answer = -1;
        row = board.length;
        col = board[0].length();
        array = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String s = board[i];
            for (int j = 0; j < col; j++) {
                array[i][j] = s.charAt(j);
                if (array[i][j] == 'R') { //로봇의 처음 위치
                    firstX = i;
                    firstY = j;
                }
                if (array[i][j] == 'G') {
                    resultX = i;
                    resultY = j;
                }
            }
        }
        queue.add(new int[]{firstX, firstY, 0});
        visited[firstX][firstY] = true;
        return bfs();
    }

    //장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 '한 번의 이동으로' 칩니다.
    public int bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int move = temp[2];

            if (x == resultX && y == resultY) {
                answer = move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int cx = x;
                int cy = y;
                while (true) {
                    cx += dx[i];
                    cy += dy[i];
                    //장애물이나 벽에 부딪혔다면
                    if (cx < 0 || cx >= row || cy < 0 || cy >= col || array[cx][cy] == 'D') {
                        cx -= dx[i];
                        cy -= dy[i];
                        break;
                    }
                }
                if (visited[cx][cy]) {
                    continue;
                }

                visited[cx][cy] = true;
                queue.add(new int[]{cx, cy, move + 1});
            }
        }
        return answer;
    }
}
