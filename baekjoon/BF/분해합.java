import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int n = Integer.parseInt(br.readLine()); //216

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int temp = i;  //198

            while (temp != 0) { //각 자릿수 더하기
                sum += temp % 10; //8, 9, 1
                temp /= 10;
            }

            if(sum + i == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
