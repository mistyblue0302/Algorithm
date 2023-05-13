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
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int val : result) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }

        int before = 0; // 이전에 뽑았던 값을 저장
        for (int i = 0; i < n; i++) {
            if (visit[i]) {  // 뽑았던 값이면
                continue;
            } else if (before != array[i]) {
                visit[i] = true;
                result[depth] = array[i];
                before = array[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }

    }
}

