import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int array[] = new int[n];
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];

        for (int i = 1; i < n; i++) {
            dp[i] = array[i];
            for (int j = 0; j < i + 1; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[j] + array[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
