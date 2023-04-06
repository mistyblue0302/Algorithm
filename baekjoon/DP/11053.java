import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            // dp의 값 1로 초기화
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // arr를 돌며 i가 j의 값보다 크고 이전 dp의 크기보다 작으면
                if (array[j] < array[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            if(dp[i] > result) {
                result = dp[i];
            }
        }
        System.out.println(result);
    }
}
