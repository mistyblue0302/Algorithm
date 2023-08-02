import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //4
        int k = Integer.parseInt(br.readLine()); //7

        long low = 1;
        long high = k;

        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (k <= count) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
