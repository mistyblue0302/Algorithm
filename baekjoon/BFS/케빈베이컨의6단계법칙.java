import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    static int n, m;
    static int[][] array;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int one = Integer.parseInt(st.nextToken());
            int other = Integer.parseInt(st.nextToken());
            array[one][other] = 1;
            array[other][one] = 1;
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i, visited);
        }
        System.out.println(result);
    }

    public static void bfs(int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0}); //1부터 따져보기, 베이컨 수 처음에 0으로 놓고 갱신

        int count = 0;
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            count += temp[1];

            for (int i = 1; i <= n; i++) {
                int num = array[temp[0]][i];
                if (num == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new int[]{i, temp[1] + 1});
                }
            }
        }

        if (min > count) {
            min = count;
            result = start;
        }
    }
}
