import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 트리와쿼리 {

    static int n, r, q;
    static boolean[] visited;
    static List<Integer> list[];
    static int[] result; //각 노드 번호를 루트로 하는 서브트리에 속한 정점의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //정점의 수
        r = Integer.parseInt(st.nextToken()); //루트의 번호
        q = Integer.parseInt(st.nextToken()); //쿼리의 수
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        visited[r] = true; //루트부터 서브트리의 정점 수 저장
        dfs(r);

        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(result[num]);
        }
    }

    public static int dfs(int node) {
        int count = 1;

        visited[node] = true;
        for (int a : list[node]) {
            if (visited[a]) {
                continue;
            }
            count += dfs(a);
        }
        return result[node] = count;
    }
}
