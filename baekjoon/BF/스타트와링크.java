package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {

    static int n;
    static int[][] array;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    public static void dfs(int depth, int at) {
        if (depth == n / 2) {
            diff();
            return;
        }

        for (int i = at; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    //두 팀의 능력치 차이를 구하는 함수
    public static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += array[i][j];
                    start += array[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += array[i][j];
                    link += array[j][i];
                }
            }
        }

        int difference = Math.abs(start - link);

        //차이가 0이되면 최소
        if (difference == 0) {
            System.out.println(difference);
            System.exit(0);
        }

        min = Math.min(difference, min);
    }
}
