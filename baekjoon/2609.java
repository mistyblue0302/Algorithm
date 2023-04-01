import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken()); //24
        int b = Integer.parseInt(st.nextToken()); //18

        int result1 = gcd(a, b);
        int result2 = (a * b) / result1;

        System.out.println(result1);
        System.out.println(result2);
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r); //a를 b로 나눈 나머지가 r이라면 a,b의 최대 공약수는 b,r의 최대공약수와 같다.
    }
}
