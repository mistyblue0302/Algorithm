package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //3
        k = Integer.parseInt(st.nextToken()); //10

        int[] array = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine()); //1
            for (int j = array[i]; j <= k; j++) {
                dp[j] += dp[j - array[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
