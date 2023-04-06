import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //수열의 크기 1<=n<=1000
        StringTokenizer st;

        int array[] = new int[n];
        int dp[] = new int[n]; //n번째 수열일 때 가장 긴 증가하는 부분 수열 길이

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int result = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
