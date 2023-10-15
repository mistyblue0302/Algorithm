import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 극장좌석 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱한다.
        int result = 1;
        int before = 0;
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine()); //4
            result *= dp[temp - before - 1]; //1
            before = temp;
        }

        result *= dp[n - before]; //마지막 vip 좌석부터 ~ 끝 좌석까지의 경우의 수
        System.out.println(result);
    }
}