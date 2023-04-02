import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //입력값이 20억이 넘기 때문
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        //2와 5가 겹치는 개수 중 최솟값
        //n!에서 사용된 2와 5의 개수를 각각 구하고 (n-r)!의 2의 개수와 r!의 2의 개수를 빼준다(5도 동일)
        long count1 = five(n) - five(n - m) - five(m);
        long count2 = two(n) - two(n - m) - two(m);

        System.out.print(Math.min(count1, count2));
    }

    static long two(long num) {
        int count = 0;
        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }

    static long five(long num) {
        int count = 0;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }
}
