import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int[] array;
    static int[] result;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        visit = new boolean[n];
        result = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int val : array) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        } else {
            int before = 0; // 이전에 뽑았던 값을 저장
            for (int i = 0; i < n; i++) {
                if (visit[i]) {  // 뽑았던 값이면
                    continue;
                } else if (before != result[i]) {
                    visit[i] = true;
                    array[depth] = result[i];
                    before = result[i];
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
