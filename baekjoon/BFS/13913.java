import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int time;
    static boolean[] visited = new boolean[100001];
    static int[] before = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            sb.append(0).append("\n");
            sb.append(n).append("\n");
        } else {
            bfs(n);
            sb.append(time).append("\n");

            Stack<Integer> stack = new Stack<>();
            stack.add(k);
            int index = k;
            while (index != n) {
                stack.push(before[index]);
                index = before[index];
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            // 만난 경우
            if (visited[k]) {
                return;
            }

            //시간 계산을 위해
            for (int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                int next;

                next = now - 1;
                if (next >= 0 && !visited[next]) {
                    visited[next] = true;
                    before[next] = now;
                    q.offer(next);
                }

                next = now + 1;
                if (next < 100001 && !visited[next]) {
                    visited[next] = true;
                    before[next] = now;
                    q.offer(next);
                }

                next = now * 2;
                if (next < 100001 && !visited[next]) {
                    visited[next] = true;
                    before[next] = now;
                    q.offer(next);
                }
            }
            time++;
        }
    }
}
