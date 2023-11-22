package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망서비스 {

    static int n;
    static List<Integer> list[];
    static int[][] dp;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int node) {
        dp[node][0] = 1; //node가 얼리어답터일 때([node][0]) 일단 최소 얼리어답터 1개 카운팅
        visited[node] = true;

        for (int next : list[node]) {
            if (visited[next]) {
                continue; //만약 방문했다면 아래의 문장을 실행하지 않고 다음 반복을 진행
            }
            dfs(next);
            dp[node][1] += dp[next][0];   //얼리어답터가 아닐 때 필요한 최소 얼리어답터([node][1])
            dp[node][0] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
