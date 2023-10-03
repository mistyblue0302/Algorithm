import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()); //2
            int y1 = Integer.parseInt(st.nextToken()); //2
            int x2 = Integer.parseInt(st.nextToken()); //3
            int y2 = Integer.parseInt(st.nextToken()); //4
            int sum = 0;

            for (int j = x1; j <= x2; j++) {
                sum += dp[j][y2] - dp[j][y1 - 1];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}
