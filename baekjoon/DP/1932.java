import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//5

        int dp[][] = new int[n + 1][n + 1];
        int array[][] = new int[n + 1][n + 1]; //i행 j열

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i; j++) { 
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = array[1][1]; // 최상층 값은 미리 저장

        for (int i = 2; i <= n; i++) { //아래층 부터 n까지 반복
            for (int j = 1; j <= i; j++) { //1번열부터 i까지 반복, i가 2일 경우 2까지 3일 경우 3까지...
                // 점화식
                if (j == 1) {
                    dp[i][j] = array[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = array[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[n][i] > max) {
                max = dp[n][i];
            }
        }
        System.out.println(max);
    }
}

