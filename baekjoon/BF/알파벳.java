package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

    public static int R, C;
    public static int[][] board;
    public static boolean[] visit;
    public static int result = 0; //최대 칸 수
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visit = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {
        if (visit[board[x][y]]) { //이미 지나간 알파벳이면
            result = Math.max(result, count);
        } else { //지나가지 않은 알파벳이면
            visit[board[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
                    dfs(cx, cy, count + 1);
                }
            }
            visit[board[x][y]] = false;
        }
    }
}