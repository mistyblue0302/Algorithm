package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] array;
    static int[][] copyArray;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0); //새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
        System.out.println(result);
    }

    public static void dfs(int wall) { //벽세우기
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) { //만약 빈칸이면
                    array[i][j] = 1; //벽을 세운다.
                    dfs(wall + 1);
                    array[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() { //바이러스 퍼뜨리기
        Queue<int[]> queue = new LinkedList<>(); //바이러스인 곳의 좌표 정보를 저장
        copyArray = new int[n][m]; //벽이 3개 세워질 때마다 bfs()를 실행해야 하는데 이 과정에서 배열의 복사 때문에

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyArray[i][j] = array[i][j];
                if (copyArray[i][j] == 2) { //바이러스라면
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && copyArray[nx][ny] == 0) {
                    copyArray[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArray[i][j] == 0) {
                    count++;
                }
            }
        }

        result = Math.max(result, count);
    }
}
