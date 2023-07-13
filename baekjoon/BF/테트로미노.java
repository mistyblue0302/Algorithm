package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {

    public static int n;
    public static int m;
    public static int[][] array;
    public static boolean[][] visit;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        array = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(1, i, j, array[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    public static void dfs(int depth, int row, int column, int sum) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = row + dx[i];
            int cy = column + dy[i];

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
                continue;
            }

            if (!visit[cx][cy]) {
                if (depth == 2) {
                    visit[cx][cy] = true;
                    dfs(depth + 1, row, column, sum + array[cx][cy]); //2번째 칸에서 다시 탐색
                    visit[cx][cy] = false;
                }

                visit[cx][cy] = true;
                dfs(depth + 1, cx, cy, sum + array[cx][cy]);
                visit[cx][cy] = false;
            }
        }
    }
}

