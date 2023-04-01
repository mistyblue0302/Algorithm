import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true;  //소수는 false

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean isPrime = false;
            for (int i = 2; i <= n / 2; i++) { //n/2를 넘어가면 작은 수 부터 나올 수 없다.
                if (!prime[i] && !prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    isPrime = true;
                    break;
                }
            }
            if (!isPrime) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

            n = Integer.parseInt(br.readLine());
        }
    }
}
