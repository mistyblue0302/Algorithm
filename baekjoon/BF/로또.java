package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {

    public static int k;
    public static int[] array;
    public static int[] result;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            array = new int[k];
            result = new int[6];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println(sb.toString());
            sb.delete(0, sb.capacity());
        }
    }

    public static void dfs(int depth, int at) {
        if (depth == 6) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = array[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}