import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구슬찾기 {

    static int n, m;
    static int[][] array;
    static int half;
    static List<Integer> list[]; // 무거운 순서로, 단방향 그래프
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 구슬의 개수
        m = Integer.parseInt(st.nextToken()); // 저울에 올려 본 쌍의 개수
        array = new int[n + 1][2]; // [i][0] : i보다 가벼운 구슬, [i][1] : i보다 무거운 구슬
        half = (n + 1) / 2;

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            list[heavy].add(light);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        for (int i = 1; i <= n; i++) {
            if (array[i][0] >= half || array[i][1] >= half) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start, int current) {
        for (int a : list[current]) {
            if (!visited[a]) {
                visited[a] = true;
                array[start][0]++;
                array[a][1]++;
                dfs(start, a);
            }
        }
    }
}

