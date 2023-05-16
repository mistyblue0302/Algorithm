import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한 도시에서 출발하여 모든 도시를 거친 후, 처음으로 돌아오는 문제 어느 도시에서 출발하든 가장 적게 드는 비용은 동일 -> 아무나 한 곳을 시작도시로 정하여 dfs를
 * 사용하여 돌아옴. 시작도시는 방문처리가 되었으므로 돌아올 때 처리를 따로 해준다.
 */
class Main {

    public static int n;
    public static int array[][];
    public static int min = Integer.MAX_VALUE;
    public static boolean visit[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //도시의 수 n

        array = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }

    public static void dfs(int start, int now, int depth, int sum) {
        if (depth == n && start == now) { //모든 도시를 순회했고, 다시 시작점으로 돌아왔다면 최솟값 갱신
            min = Math.min(min, sum);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            // i번째 도시와 이어져있지 않다면 넘어간다.
            if (array[now][i] == 0) {
                continue;
            }

            // 현재 도시를 방문하지 않았고, 다음 순회할 i번째 도시와 연결되어 있다면
            if (!visit[now] && array[now][i] > 0) {
                visit[now] = true;
                sum += array[now][i];
                dfs(start, i, depth + 1, sum); // now를 i번째 도시로 갱신하고, 깊이를 1 증가
                visit[now] = false;
                sum -= array[now][i];
            }
        }
    }
}
