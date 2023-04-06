import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //길이가 n

        long dp[][] = new long[n + 1][10]; // 자릿수가 n이고 각각의 자릿값(0~9)를 의미

        //오른쪽 맨 끝의 자릿수(길이가1)
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        //두 번째 자릿수부터 탐색
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) { //자릿값 탐색(0~9)
                //자릿수의 값이 0 : 다음 자리수는 무조건 1 ex) 10 -> 101
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                } else if (j == 9) { //자릿수의 값이 9 : 다음 자리수는 무조건 8 ex) 19 -> 198
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        System.out.println(result % 1000000000);
    }
}
