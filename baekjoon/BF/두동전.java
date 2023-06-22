package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두동전 {

    public static int n, m;
    public static char[][] board;
    public static int min = Integer.MAX_VALUE; //min을 기본값으로 두고 변경이 없으면 -1 출력
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int x1, x2, y1, y2;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'o') { //동전이면 위치를 좌표에 별도로 담는다.
                    if (flag) {
                        x1 = j;
                        y1 = i;
                    } else {
                        x2 = j;
                        y2 = i;
                        flag = true;
                    }
                }
            }
        }
        bf(new Coin(x1, y1, x2, y2), 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void bf(Coin coin, int buttonCount) {
        if (buttonCount >= 10 || buttonCount >= min) { //두 동전을 떨어뜨릴 수 없거나, 버튼을 10번보다 많이 눌러야 한다면
            return;
        }

        for (int i = 0; i < 4; i++) {
            int out = 0;
            int nextX1 = coin.x1 + dx[i];
            int nextY1 = coin.y1 + dy[i];
            int nextX2 = coin.x2 + dx[i];
            int nextY2 = coin.y2 + dy[i];

            //밖으로 떨어지는 개수 세기
            if (nextX1 < 0 || nextX1 >= m || nextY1 < 0 || nextY1 >= n) {
                out++;
            }
            if (nextX2 < 0 || nextX2 >= m || nextY2 < 0 || nextY2 >= n) {
                out++;
            }

            if (out == 2) {
                continue;
            }

            if (out == 1) {
                min = Math.min(min, buttonCount + 1);
                return;
            }

            if (board[nextY1][nextX1] == '#') { // 벽이면
                nextX1 = coin.x1;
                nextY1 = coin.y1;
            }
            if (board[nextY2][nextX2] == '#') { // 벽이면
                nextX2 = coin.x2;
                nextY2 = coin.y2;
            }
            bf(new Coin(nextX1, nextY1, nextX2, nextY2), buttonCount + 1);
        }
    }
}

class Coin { //각 동전의 초기 위치

    int x1;
    int y1;
    int x2;
    int y2;


    public Coin(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
