import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {

    static int n;

    static List<int[]> list[];
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[parent].add(new int[]{child, value});
            list[child].add(new int[]{parent, value});  //양방향으로 움직일 수 있으므로
        }

        for (int i = 1; i < list.length; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0); //지름을 구하기 위해 노드를 다 넣어본다.
        }
        System.out.println(max);
    }

    public static void dfs(int node, int diameter) {
        visited[node] = true;
        max = Math.max(max, diameter);

        for (int[] a : list[node]) {
            int child = a[0];
            int value = a[1];

            if (!visited[child]) {
                dfs(child, diameter + value);
            }
        }
    }
}
