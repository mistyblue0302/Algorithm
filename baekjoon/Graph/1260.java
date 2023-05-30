import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int v;
    public static boolean visited[];
    public static int array[][];
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //정점의 수
        m = sc.nextInt(); //간선의 수
        v = sc.nextInt(); //탐색 시작 번호

        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //정점의 번호
            int b = sc.nextInt(); //정점의 번호
            array[a][b] = 1;
            array[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];

        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx).append(" ");

        for (int i = 0; i <= n; i++) {
            if (array[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int idx) {
        queue.add(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + " ");

            for (int i = 0; i <= n; i++) {
                if (array[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
