package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인해킹 {

    public static int n, m;
    public static List<Integer> list[];
    public static boolean[] visited;
    public static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }


        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (answer[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int start, int now) {
        for (int next : list[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(start, next);
                answer[start]++;
            }
        }
    }
}
