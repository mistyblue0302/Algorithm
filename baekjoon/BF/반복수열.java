package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 반복수열 {

    static int A;
    static int P;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); //57
        P = Integer.parseInt(st.nextToken()); //2

        list.add(A);
        while (true) {
            int number = calculate(A, P);

            if(list.contains(number)) {
                System.out.println(list.indexOf(number));
                break;
            }
            list.add(number);
            A = number;
        }
    }

    public static int calculate(int A, int P) { //수열의 규칙에따라 숫자를 계산하는 메소드
        int num = 0;
        while (A != 0) {
            num += (int) Math.pow(A % 10, P);
            A /= 10;
        }
        return num;
    }
}
