import java.util.*;

class Main { //최단 거리 : bfs

    private static int n, m;
    private static int[][] array;
    private static boolean[][] visited;
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(array[n - 1][m - 1]);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); // Queue에 배열의 i,j값을 한쌍으로 저장
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int nx = temp[0];
            int ny = temp[1];

            for (int i = 0; i < 4; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (array[cx][cy] == 1 && !visited[cx][cy]) {
                        queue.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                        array[cx][cy] = array[nx][ny] + 1;
                    }
                }
            }
        }
    }
}
