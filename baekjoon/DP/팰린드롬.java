package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        boolean[][] dp = new boolean[n][n]; //n부터 n까지 팰린드롬인지 판별하는 배열

        //길이가 1인 것은 모두 팰린드롬
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //길이가 2인 것은 서로 같으면 팰린드롬
        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                dp[i][i + 1] = true;
                dp[i + 1][i] = true;
            }
        }

        //길이가 3이상
        for (int i = 2; i < n; i++) { //길이
            for (int j = 0; j < n - i; j++) { //인덱스
                if (array[j] == array[j + i] && dp[j + 1][j + i - 1]) { //dp로 그 사이값이 팰린드롬 인지 판별
                    dp[j][j + i] = true;
                    dp[j + i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (dp[s][e]) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
