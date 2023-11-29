package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프 {

    private static List<List<Integer>> graph;
    private static int[] colors;
    private static final int RED = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < k; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            colors = new int[V+1];

            for(int vertex =0 ; vertex <= V; vertex++) {
                graph.add(new ArrayList<>());
            }

            for(int edge = 0; edge < E; edge++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean flag = false;
            for(int vertex = 1; vertex <= V; vertex++) {
                if(colors[vertex] == 0) {
                    flag = bfs(vertex, RED);
                }
                if(!flag) break;
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }

    private static boolean bfs(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 2. 시작 정점 임의의 색상으로 색칠
        colors[start] = color;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                // 4. 인접 정점 색이 동일하면 이분 그래프가 아님
                if(colors[cur] == colors[next]) return false;

                // 3. 인접 정점 색칠 안된 경우 현재 정점 반대 색깔로 색칠
                // 색상 배열을 통해 방문 여부 확인 가능
                if(colors[next] == 0) {
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}


















