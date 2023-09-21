package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int m, n, h;
    static int[][][] array;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    //몇 일이 지나면 다 익게 되는지 최소 일수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        array = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    array[i][j][k] = Integer.parseInt(st.nextToken());
                    if (array[i][j][k] == 1) { //만약 익은 토마토라면 큐에 넣기
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int z = temp[0];
            int x = temp[1];
            int y = temp[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) {
                    continue;
                }

                if (array[nz][nx][ny] == 0) { //토마토가 익지 않았으면
                    queue.add(new int[]{nz, nx, ny});
                    array[nz][nx][ny] = array[z][x][y] + 1; //익은 날짜를 얻기 위해 전 값에서 1 증가
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (array[i][j][k] == 0) { //만약 안 익은 토마토가 있다면
                        return -1;
                    }
                    max = Math.max(max, array[i][j][k]);
                }
            }
        }

        if(max == 1) { //만약 저장될 때부터 모든 토마토가 익어있는 상태이면
            return 0;
        } else {
            return max -1;
        }
    }
}

