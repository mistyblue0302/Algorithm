package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 가장 작은 수가 나오려면 빼는 수가 커야한다.
         * 즉, 뺄셈을 기준으로 나눈다.
         */
        int result = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            int sum = 0;

            StringTokenizer divide = new StringTokenizer(st.nextToken(), "+");
            while (divide.hasMoreTokens()) {
                sum += Integer.parseInt(divide.nextToken());
            }

            if(result == Integer.MAX_VALUE) {
                result = sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
