import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //3

        long dp[] = new long[1000001];
        long array[] = new long[t];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int num = 0;
        for (int i = 0; i < t; i++) {
            num = Integer.parseInt(br.readLine());
            if (num > 3) {
                for (int j = 4; j <= num; j++) {
                    dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
                }
            }
            array[i] = dp[num];
        }

        for (int i = 0; i < t; i++) {
            System.out.println(array[i]);
        }
    }
}
