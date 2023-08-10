package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {

    static int k, w, h;
    static int[][] array;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); //5
        h = Integer.parseInt(st.nextToken()); //2

        array = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[h][w][k + 1];

        visited[x][y][0] = true;
        queue.add(new int[]{x, y, 0, 0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];
            int horse = pos[2]; //말 이동 찬스
            int move = pos[3]; //총 이동 횟수

            //도착지점에서 총 이동 횟수를 리턴
            if (cx == h - 1 && cy == w - 1) {
                return move;
            }

            //기본 이동 : 원숭이 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx > h - 1 || ny < 0 || ny > w - 1) {
                    continue;
                }
                if (visited[nx][ny][horse]) { //내가 가려는 곳에 이미 방문했다면, 나보다 빠른 것
                    continue;
                }

                if (array[nx][ny] != 1) { //벽이 아니라면
                    visited[nx][ny][horse] = true;
                    queue.add(new int[]{nx, ny, horse, move + 1});
                }
            }

            //말 찬스 이동 : 찬스 남아있으면 말 8가지 방향 탐색
            if (horse < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = cx + hx[i];
                    int ny = cy + hy[i];

                    if (nx < 0 || nx > h - 1 || ny < 0 || ny > w - 1) {
                        continue;
                    }
                    if (visited[nx][ny][horse + 1]) {
                        continue;
                    }

                    if (array[nx][ny] != 1) {
                        visited[nx][ny][horse + 1] = true;
                        queue.add(new int[]{nx, ny, horse + 1, move + 1});
                    }
                }
            }
        }
        return -1;
    }
}