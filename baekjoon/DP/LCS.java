package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine(); //ACAYKP
        String b = br.readLine(); //CAPCAK

        int[][] dp = new int[b.length() + 1][a.length() + 1];

        //윗 행 : 두 번째 문자열 C가 ACA까지 비교하면서 얻은 최대 LCS값
        //왼쪽 열 : 두 번째 문자열 A가 AC까지 비교하면서 얻은 최대 LCS값
        //왼쪽 대각선 위 : 각 이전 문자열의 문자가 해당 위치에서 가질 수 있는 최대 LCS값
        //해당 위치의 문자가 일치하면(ex. ACA과 CA) : 왼쪽 대각선 위의 값 + 1
        //일치하지 않으면 : 윗행과 왼쪽 열중 큰 값
        for (int i = 1; i < dp.length; i++) {
            char c = b.charAt(i - 1);
            for (int j = 1; j < dp[0].length; j++) {
                if (c == a.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[b.length()][a.length()]);
    }
}