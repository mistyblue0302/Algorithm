package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합2 {

    public static int n;
    public static int[] array;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visit = new boolean[100000 * 20 + 1]; //S는 최대 100000이고, 크기는 최대 20

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]) {
                System.out.println(i);
                break;
            }
        }

    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            visit[sum] = true;
            return;
        } else {
            dfs(depth + 1, sum + array[depth]);
            dfs(depth + 1, sum);
        }
    }
}

