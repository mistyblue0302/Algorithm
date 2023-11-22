package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회2 {

    static int n;
    static int[] l;
    static int[] r;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l = new int[n + 1];
        r = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            l[cur] = left;
            r[cur] = right;
        }
        System.out.println(2 * (n - 1) - findEndNode(1, 0));
    }

    //중위 순회의 맨 마지막 노드를 방문하는 과정을 제외하고 각각의 노드를 방문하고, 다시 돌아온다.
    //다만, 중위 순회의 맨 마지막 노드를 방문할 때에는 한 번 간 간선을 다시 돌아오지 않는다.
    //트리는 n개의 노드를 가지면 n-1개의 간선을 가진다. 총 간선의 개수는 2*(n-1)이며 맨 마지막 노드를 방문하는 간선은 해당 노드의 depth와 같다.
    public static int findEndNode(int cur, int depth) {
        if (r[cur] != -1) {
            return findEndNode(r[cur], depth + 1);
        }
        return depth;
    }
}
