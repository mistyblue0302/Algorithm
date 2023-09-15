package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빙산 {

    static int n, m;
    static int[][] array;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            if (countIce(array) == 0) { //만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력
                answer = 0;
                break;
            }
            if (countIce(array) >= 2) {
                break;
            }
            bfs();
            answer++;
        }
        System.out.println(answer);

    }

    public static void bfs() { //빙산이 녹을 때 모든 빙산은 같은 시간에 처리되어야 하기 때문에
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] != 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                if (array[nx][ny] == 0) {
                    if (array[x][y] > 0)
                        array[x][y]--;
                }
            }
        }
    }

    public static int countIce(int[][] array) { //빙산의 덩어리수 체크
        int count = 0;
        boolean[][] check = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] != 0 && !check[i][j]) {
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        int x = temp[0];
                        int y = temp[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (array[nx][ny] == 0 || check[nx][ny]) continue;
                            queue.offer(new int[]{nx, ny});
                            check[nx][ny] = true;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}