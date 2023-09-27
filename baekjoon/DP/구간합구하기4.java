import java.io.*;
import java.util.Scanner;

public class 구간합구하기4 {

    static int n, m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n + 1];

        array[0] = 0;
        for (int i = 1; i < array.length; i++) {
            //0 5 9 12 14 15
            //array[i] : (0번째 인덱스부터 i번째 수까지의 합)
            array[i] = array[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(array[end] - array[first - 1]);
        }
    }
}