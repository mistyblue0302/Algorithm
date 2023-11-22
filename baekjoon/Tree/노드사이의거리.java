package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 노드사이의거리 {

    static int n, m;
    static List<Node> list[];
    static int result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static class Node {

        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //노드의 개수
        m = Integer.parseInt(st.nextToken()); //노드 쌍의 개수
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, distance));
            list[end].add(new Node(start, distance));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            result = 0;
            dfs(start, end, 0);
            sb.append(result).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int start, int end, int distance) {
        if (start == end) {
            result = distance;
            return;
        }

        visited[start] = true;
        for (Node n : list[start]) {
            if(!visited[n.end]) {
                dfs(n.end, end, distance + n.distance);
            }
        }
    }
}

