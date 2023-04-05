import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //구매하려고 하는 카드의 개수 : 4
        int array[] = new int[n + 1]; //n개의 카드를 구매하기 위해 지불해야 하는 금액
        int result[] = new int[n + 1]; //n개의 카드를 구매하기 위해 지불해야 하는 최댓값

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //1 5 6 7

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] = Math.max(result[i], result[i - j] + array[j]);
            }
        }
        System.out.println(result[n]);
    }
}
