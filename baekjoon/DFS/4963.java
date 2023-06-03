import java.util.*;

class Main {

    private static int w, h;
    private static int dx[] = {0, 0, 1, 1, -1, -1, 1, -1};
    private static int dy[] = {1, -1, 1, -1, 1, -1, 0, 0};
    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt(); // 너비
            h = sc.nextInt(); // 높이

            array = new int[h][w];
            visited = new boolean[h][w];

            if (w == 0 && h == 0) {
                break;
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (array[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (!visited[nx][ny] && array[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
