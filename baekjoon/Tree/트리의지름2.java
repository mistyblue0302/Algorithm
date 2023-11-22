package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름2 {

    static List<int[]> list[];
    static boolean[] visited;
    static int max = 0;
    static int farNode = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());

                list[node].add(new int[]{num, distance});
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0); //임의의 노드에서 dfs를 통해 각 노드까지의 거리를 계산 후 가장 먼 노드를 기록한다.

        visited = new boolean[v + 1];
        dfs(farNode, 0);
        System.out.println(max);
    }

    public static void dfs(int node, int distance) {
        visited[node] = true;
        if (max < distance) {
            max = distance;
            farNode = node; //가장 먼 노드를 저장한다
        }

        for (int[] array : list[node]) {
            int next = array[0];
            int diameter = array[1];
            if (!visited[next]) {
                dfs(next, distance + diameter);
            }
        }
    }
}
