import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int[] result;
    static int[] array;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        visit = new boolean[n];
        array = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int at) {
        if (depth == m) {
            for (int val : result) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for (int i = at; i < n; i++) {
            if (before != array[i]) {
                result[depth] = array[i];
                dfs(depth + 1, i);
                before = array[i];
            }
        }
    }
}
