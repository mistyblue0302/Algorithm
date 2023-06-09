import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main { //최소 이동 : bfs

    public static int n;
    public static int t;
    public static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int x1, x2;
    public static int y1, y2;
    public static Queue<int[]> queue = new LinkedList<>();
    public static boolean visit[][];
    public static int array[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            array = new int[n][n];
            visit = new boolean[n][n];

            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(array[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        queue.add(new int[]{x1, y1});
        visit[x1][y1] = true;

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                    if (!visit[cx][cy]) {
                        queue.add(new int[]{cx, cy});
                        array[cx][cy] = array[nx][ny] + 1;
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }
}
