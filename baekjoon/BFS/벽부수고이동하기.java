import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기 {
    static int n, m;
    static int[][] array;

    static int[][] distance;
    static boolean[][][] visited;
    public static int[] dx = {-1, 0, 1, 0};

    public static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m][2];

        //시작지점과 도착지점이 같을 경우
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.print(1);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }
        queue.offer(new int[]{0, 0, 0});
        bfs();
        System.out.println(result);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int w = temp[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || n <= nx || m <= ny) {
                    continue;
                }

                if (array[nx][ny] == 1) {
                    if (w == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][w] = true;    // 방문 처리
                        distance[nx][ny] = distance[x][y] + 1; // 거리 측정
                        queue.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    if (!visited[nx][ny][w]) {
                        visited[nx][ny][w] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny, w});
                    }
                }

                if (nx == n - 1 && ny == m - 1) {
                    result = distance[nx][ny] + 1;
                    return;
                }
            }
        }
    }
}
