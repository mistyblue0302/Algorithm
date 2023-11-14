import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 트리 {

    static int n, m;
    static List<Integer> list[];
    static boolean visited[];
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 1; //테스트 케이스 번호를 나타내는 변수 추가
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); //정점의 개수
            m = Integer.parseInt(st.nextToken()); //간선의 개수

            if (n == 0 && m == 0) {
                break; //입력 종료 조건
            }

            list = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    count += dfs(i);
                }
            }

            sb.append("Case ").append(testCase).append(": ");
            if (count == 0) {
                sb.append("No trees.");
            } else if (count == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
            testCase++;
        }
        System.out.println(sb.toString());
    }

    public static int dfs(int start) {
        //트리의 경우 노드개수 = 간선 개수 + 1을 활용한다. 양방향 간선으로 그래프를 구성하였기 때문에
        //node의 개수 = (간선개수 / 2) + 1이면 트리이다.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int node = 0;
        int edge = 0;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            node += 1;
            visited[temp] = true;

            for (int a : list[temp]) {
                edge += 1;
                if (!visited[a]) {
                    queue.offer(a);
                }
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;
    }
}
