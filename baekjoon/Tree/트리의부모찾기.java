import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static int n;
    static List<Integer> list[];
    static boolean[] visited;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        tree = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //루트를 1이라고 정했을 때, 2번 노드부터 각 노드의 부모를 구한다
        dfs(1);

        for (int i = 2; i < tree.length; i++) {
            System.out.println(tree[i]);
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int a : list[node]) {
            if (!visited[a]) {
                tree[a] = node;
                dfs(a);
            }
        }
    }
}