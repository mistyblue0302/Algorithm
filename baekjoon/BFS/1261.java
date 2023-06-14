import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int array[][];
    public static boolean visit[][];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    //벽을 더 적게 부수는 방법으로 가야 하니까 빈방이면 addFirst(), 벽인 경우 addLast()
    //그럼 BFS를 수행하며 Deque에서 값을 앞에서부터 하나씩 꺼내올 때 우선순위가 더 높은 빈방의 경우부터 나오게 될 것
    public static Deque<int[]> queue = new ArrayDeque<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //4
        n = sc.nextInt(); //2

        array = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        queue.add(new int[]{0, 0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int cx = now[0];
            int cy = now[1];

            if (cx == n - 1 && cy == m - 1) {
                System.out.println(now[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                if (array[nx][ny] == 1) {
                    queue.addLast(new int[]{nx, ny, now[2] + 1});
                } else {
                    queue.addFirst(new int[]{nx, ny, now[2]});
                }
            }
        }
    }
}
