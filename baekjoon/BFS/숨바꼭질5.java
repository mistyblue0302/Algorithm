import java.util.*;
import java.io.*;

public class 숨바꼭질5 {

    static int n, k;
    static boolean[][] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[2][500001];

        System.out.println(n == k ? 0 : bfs());
    }

    //짝수 시간에 방문했던 지점은 짝수 시간에 다시 돌아올 수 있고,
    //홀수 시간에 방문한 지점은 홀수 시간에 다시 돌아올 수 있다.
    public static int bfs() {
        queue.add(n);
        visited[0][n] = true; //visited[0][] = 짝수 초, visited[1][n] = 홀수 초

        int time = 0;
        int mod = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            mod = time % 2; //0이면 짝수, 1이면 홀수

            k += time;

            if (k > 500000) {
                return -1;
            }

            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp - 1 >= 0 && !visited[mod][temp - 1]) {
                    queue.offer(temp - 1);
                    visited[mod][temp - 1] = true;
                }
                if (temp + 1 <= 500000 && !visited[mod][temp + 1]) {
                    queue.offer(temp + 1);
                    visited[mod][temp + 1] = true;
                }

                if (temp * 2 <= 500000 && !visited[mod][temp * 2]) {
                    queue.offer(temp * 2);
                    visited[mod][temp * 2] = true;
                }
            }

            if (visited[mod][k]) {
                return time;
            }

        }
        return -1;
    }
}
