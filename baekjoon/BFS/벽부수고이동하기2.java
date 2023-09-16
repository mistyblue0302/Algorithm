import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기2 {

    static int n, m, k;
    static int[][] array;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        queue.add(new int[]{0, 0, 0, 1}); //0,0에서 n-1, m-1의 위치까지, 좌표, 벽 개수, 거리
        visited[0][0][0] = true;
        bfs();
        System.out.println(result);
    }

    //벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.
    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int wall = temp[2];
            int distance = temp[3];

            if (x == n - 1 && y == m - 1) {
                result = distance;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;

                if (array[cx][cy] == 0 && !visited[cx][cy][wall]) {  //0이라 이동할 수 있고 방문하지 않았다면
                    visited[cx][cy][wall] = true;
                    queue.add(new int[]{cx, cy, wall, distance + 1});
                } else if (array[cx][cy] == 1) {  //1이라 벽을 만났다면
                    if (wall < k && !visited[cx][cy][wall + 1]) {
                        // 벽을 뚫을 수 있고 아직 방문하지 않았다면
                        visited[cx][cy][wall + 1] = true;
                        queue.add(new int[]{cx, cy, wall + 1, distance + 1});
                    }
                }
            }
        }
    }
}
