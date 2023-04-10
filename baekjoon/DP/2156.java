import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] array = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        // 첫잔일 경우
        if (n >= 1) {
            dp[0] = array[0];
        }
        // 두잔일 경우
        if (n >= 2) {
            dp[1] = array[0] + array[1];
        }
        // 세잔일 경우
        if (n >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + array[2], array[1] + array[2]));
        }
        
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + array[i], dp[i - 3] + array[i - 1] + array[i]));
        }
        System.out.println(dp[n - 1]);
    }
}
