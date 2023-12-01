package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {

    static int n, m, v;
    static int[][] array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a][b] = 1;
            array[b][a] = 1;
        }
        sb.append(v).append(' ');
        dfs(v);
        System.out.println(sb.toString());

        sb.delete(0, sb.length());

        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= n; i++) {
            if (array[start][i] == 1 && !visited[i]) {
                sb.append(i).append(' ');
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(' ');
            for (int i = 0; i <= n; i++) {
                if (array[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

