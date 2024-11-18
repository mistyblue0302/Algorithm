import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;

        int result = 0;
        while (left < right) {
            int mid = (left + right) / 2; // 6
            int count = 0; // mid보다 작거나 같은 원소의 개수

            // count의 개수가 k(인덱스)와 같다면 답
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
