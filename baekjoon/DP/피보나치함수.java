import java.io.*;
import java.util.Scanner;

public class 피보나치함수 {

    static int t;
    static int[] zero;
    static int[] one;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //0

            zero = new int[40 + 1];
            one = new int[40 + 1];
            zero[0] = 1;
            zero[1] = 0;
            one[0] = 0;
            one[1] = 1;
            for (int j = 2; j < zero.length; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }
            sb.append(zero[n]).append(" ").append(one[n]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}