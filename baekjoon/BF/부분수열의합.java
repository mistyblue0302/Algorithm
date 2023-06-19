package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {

    public static int n, s;
    public static int[] array;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //정수의 개수 : 5
        s = Integer.parseInt(st.nextToken()); //합이 s : 0

        array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0); //합이 0이 되는 부분수열의 개수

        if (s == 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                result++;
            }
            return;
        }

        dfs(depth + 1, sum + array[depth]);
        dfs(depth + 1, sum);
    }
}
