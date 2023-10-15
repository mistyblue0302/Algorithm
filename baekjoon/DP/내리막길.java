package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {

    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        array = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (dp[x][y] == -1) { //방문한 적이 없는 경우
            dp[x][y] = 0; //방문여부 체크
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx < 0 || cx >= m || cy < 0 || cy >= n) {
                    continue;
                }

                if (array[cx][cy] < array[x][y]) {
                    dp[x][y] += dfs(cx,
                        cy); //dfs는 도착지점에 도착하면 1을 리턴하므로 경로를 하나 찾을 때마다 dp[0][0]에 더하게 된다.
                }
            }
        }

        return dp[x][y];
    }
}
