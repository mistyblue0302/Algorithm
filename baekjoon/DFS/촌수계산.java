package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {

    static int n;
    static int[][] array;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //전체 사람의 수
        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int one = Integer.parseInt(st.nextToken());
        int other = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            array[parent][child] = 1;
            array[child][parent] = 1;
        }

        dfs(one, other, 0);
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int one, int other, int count) {
        if (one == other) {
            answer = count;
            return;
        }

        visited[one] = true;
        for (int i = 1; i <= n; i++) {
            if (array[one][i] == 1 && !visited[i]) {
                dfs(i, other, count + 1);
            }
        }
    }
}
