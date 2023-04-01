import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean prime[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken()); //3
        int n = Integer.parseInt(st.nextToken()); //16

        prime = new boolean[n + 1];
        getPrime();

        StringBuilder sb = new StringBuilder();

        for (int i = m; i <= n; i++) {
            if (!prime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    //true : 소수아님, false : 소수(2부터)
    public static void getPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
