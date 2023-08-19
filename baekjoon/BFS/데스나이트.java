import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 데스나이트 {

    static int n;
    static int r1, c1, r2, c2;
    static int dx[] = {-2, -2, 0, 0, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int result = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1][n + 1];

        String[] temp = br.readLine().split(" ");
        r1 = Integer.parseInt(temp[0]);
        c1 = Integer.parseInt(temp[1]);
        r2 = Integer.parseInt(temp[2]);
        c2 = Integer.parseInt(temp[3]);

        bfs();
        System.out.println(result == 0 ? -1 : result);
    }

    public static void bfs() {
        queue.offer(new int[]{r1, c1, 0});
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int distance = temp[2];

            if (x == r2 && y == c2) {
                result = distance;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx >= 0 && cx <= n && cy >= 0 && cy <= n && !visited[cx][cy]) {
                    queue.offer(new int[]{cx, cy, distance + 1});
                    visited[cx][cy] = true;
                }
            }
        }
    }
}