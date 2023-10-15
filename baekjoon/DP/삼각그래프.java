import java.util.Scanner;

public class 삼각그래프 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = 1;
        while (true) {
            int n = sc.nextInt(); //4
            if (n == 0) {
                break;
            }

            int[][] dp = new int[n][3];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    for (int j = 0; j < 3; j++) {
                        if (j == 0) {
                            dp[i][0] += dp[i - 1][1];
                        } else {
                            dp[i][j] += Math.min(dp[i][j - 1], Math.min(dp[i - 1][1], dp[i - 1][1] + dp[i - 1][2]));
                        }
                    }
                } else {
                    dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] += Math.min(Math.min(dp[i][0], dp[i - 1][0]),
                            Math.min(dp[i - 1][1], dp[i - 1][2]));
                    dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
                }
            }
            System.out.println(testCase + ". " + dp[n - 1][1]);
            testCase++;
        }
    }
}