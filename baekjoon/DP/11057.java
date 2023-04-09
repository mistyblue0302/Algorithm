import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[길이][숫자 가장 앞자리 수]
        long dp[][] = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k] % 10007);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
            answer %= 10007;
        }
        System.out.println(answer);
    }
}
