import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {

    static int n;
    static boolean[] visited;
    static List<int[]> list[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new int[]{child, weight});
            list[child].add(new int[]{parent, weight});
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int node, int distance) {
        visited[node] = true;
        max = Math.max(max, distance);

        for (int[] array : list[node]) {
            if (visited[array[0]]) {
                continue;
            }
            dfs(array[0], distance + array[1]);
        }
    }
}