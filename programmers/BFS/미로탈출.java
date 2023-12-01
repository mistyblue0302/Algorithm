package BFS;

import java.util.*;

class 미로탈출 {

    static char[][] array;
    static boolean[][] visited;
    static int startX, startY, endX, endY;
    static int leverX, leverY;
    static int row, col;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public int solution(String[] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length();
        array = new char[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = maps[i].charAt(j);
                if (array[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (array[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
                if (array[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }

        //시작지점 ~ 레버
        answer = bfs(startX, startY, leverX, leverY);
        if (answer > -1) {
            queue.clear();
            visited = new boolean[row][col];
            int temp = bfs(leverX, leverY, endX, endY); //레버 ~ 도착지점
            if (temp == -1) {
                answer = -1;

            } else {
                answer += temp;
            }
        }
        return answer;
    }

    public int bfs(int startX, int startY, int endX, int endY) {
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int distance = temp[2];
            if (x == endX && y == endY) {
                return distance;
            }
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx < 0 || cx >= row || cy < 0 || cy >= col) {
                    continue;
                }
                if (!visited[cx][cy] && array[cx][cy] != 'X') {
                    queue.add(new int[]{cx, cy, distance + 1});
                    visited[cx][cy] = true;
                }
            }
        }
        return -1;
    }
}