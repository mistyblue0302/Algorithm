package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {

    static int n;
    static char[][] array;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static boolean[][] visited2;
    static int color = 0;
    static int color2 = 0;

    //적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new char[n][n];
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { //적록색약이 아닌 사람
                    color++;
                    dfs(i, j);
                }
                if (!visited2[i][j]) { //적록색약인 사람
                    color2++;
                    dfs2(i, j);
                }
            }
        }

        System.out.println(color);
        System.out.println(color2);
    }

    public static void dfs(int x, int y) { //적록색약 체크 x
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cx >= n || cy < 0 || cy >= n || visited[cx][cy]) {
                continue;
            }

            if (!visited[cx][cy] && array[x][y] == array[cx][cy]) { //방문하지 않았고, 색이 같으면
                dfs(cx, cy);
            }
        }
    }

    public static void dfs2(int x, int y) { //적록색약 체크 o
        visited2[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cx >= n || cy < 0 || cy >= n || visited2[cx][cy]) {
                continue;
            }

            if (!visited2[cx][cy]) {
                if ((array[x][y] == 'R' || array[x][y] == 'G') && (array[cx][cy] == 'R'
                    || array[cx][cy] == 'G')) { //방문하지 않았고, 색이 같으면
                    dfs2(cx, cy);
                } else if (array[x][y] == array[cx][cy]) {
                    dfs2(cx, cy);
                }
            }
        }
    }
}
