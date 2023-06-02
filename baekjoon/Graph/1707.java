import java.util.*;

class Main { //bfs를 진행하는데, 시작 정점을 임의의 색상으로 칠하고 연결된 정점을 다른 색상으로 칠한다. 연결된 정점이
             // 서로 동일한 색상을 가지는 경우 이분 그래프가 아니므로 false 리턴

    public static int k;
    public static List<List<Integer>> graph;
    public static int[] colors;
    public static final int RED = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); //테스트 케이스의 개수 

        for (int i = 0; i < k; i++) {
            int V = sc.nextInt(); //정점 개수 
            int E = sc.nextInt(); //간선 개수 
            graph = new ArrayList<>();
            colors = new int[V + 1];
            //그래프 초기화
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            //그래프 연결
            for (int m = 0; m < E; m++) {
                int u = sc.nextInt(); 
                int v = sc.nextInt(); 
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean flag = false;

            for (int n = 1; n <= V; n++) {
                if (colors[n] == 0) {
                    flag = isBipartiteGraph(n, RED);
                }
                if (!flag) break;
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartiteGraph(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = color;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int next : graph.get(temp)) {
                //인접 정점 색이 동일하면 이분 그래프가 아니다.
                if (colors[temp] == colors[next]) return false;
                //인접 정점이 색칠 되지 않은 경우 현재 정점의 반대 색깔로 칠한다.(연결된 정점은 다른 색으로 칠한다)
                if (colors[next] == 0) {
                    colors[next] = colors[temp] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}



