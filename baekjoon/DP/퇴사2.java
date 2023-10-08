package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] day = new int[n + 2];
        int[] cost = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            int temp = i + day[i];
            if (temp <= n + 1) {
                dp[temp] = Math.max(dp[temp], max + cost[i]);
            }
        }

        System.out.println(max);
    }
}

