package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); //동전의 가지 수
            int[] coin = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); //1 2
            for (int i = 0; i < coin.length; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine()); //만들어야 할 금액 1000
            int[] dp = new int[m + 1];

            for (int i = 0; i < coin.length; i++) {
                for (int j = 1; j < dp.length; j++) {
                    if (j - coin[i] == 0) {
                        dp[j]++;
                    } else if (j - coin[i] > 0) {
                        dp[j] = dp[j] + dp[j - coin[i]];
                    }
                }
            }
            System.out.println(dp[m]);
        }
    }
}
