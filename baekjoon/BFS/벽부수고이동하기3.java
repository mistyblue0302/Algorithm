import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간초과 해결 못함
 */
public class 벽부수고이동하기3 {

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int map[][];
    static boolean visit[][][][];
    static int n, m, k, result;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        result = -1;
        queue.add(new int[]{0, 0, 1, 0, 0}); //x, y, dist, wall, day
        visit[0][0][0][0] = true;
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int distance = temp[2];
            int wall = temp[3];
            int day = temp[4];

            if (x == n - 1 && y == m - 1) {
                result = distance;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0|| nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == 0) { //낮은 0 밤은 1
                    if (day == 0 && !visit[nx][ny][wall][day + 1]) {
                        queue.add(new int[]{nx, ny, distance + 1, wall, day + 1});
                        visit[nx][ny][wall][day + 1] = true;
                    } else if (day == 1 && !visit[nx][ny][wall][day - 1]) {
                        queue.add(new int[]{nx, ny, distance + 1, wall, day - 1});
                        visit[nx][ny][wall][day - 1] = true;
                    }
                } else {
                    if (wall < k && day == 0 && !visit[nx][ny][wall + 1][day + 1]) {
                        visit[nx][ny][wall + 1][day + 1] = true;
                        queue.add(new int[]{nx, ny, distance + 1, wall + 1, day + 1});
                    } else if (wall < k && day == 1 && !visit[x][y][wall][day - 1]) {
                        visit[x][y][wall][day - 1] = true;
                        queue.add(new int[]{x, y, distance + 1, wall, day - 1});
                    }
                }
            }
        }
    }
}
