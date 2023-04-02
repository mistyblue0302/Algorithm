import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true; //소수면 false;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        while (t-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 2; i <= temp / 2; i++) {
                if (!prime[i] && !prime[temp - i]) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
