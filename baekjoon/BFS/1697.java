import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] visit = new int[100001];
    public static int n, k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //5(수빈이위치)
        k = Integer.parseInt(st.nextToken()); //17(동생위치)

        int result = bfs(n);
        System.out.println(result);
    }

    public static int bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        int index = number;
        visit[index] = 1; //visit[5] = 1 : 0초(처음)에 방문한 노드를 1이라고표기

        while (!queue.isEmpty()) {
            int temp = queue.poll(); //5

            if (temp == k) {
                return visit[temp] - 1;
            }

            if (temp - 1 >= 0 && visit[temp - 1] == 0) {
                visit[temp - 1] = visit[temp] + 1;
                queue.add(temp - 1);
            }

            if (temp + 1 <= 100000 && visit[temp + 1] == 0) {
                visit[temp + 1] = visit[temp] + 1;
                queue.add(temp + 1);
            }

            if (temp * 2 <= 100000 && visit[temp * 2] == 0) {
                visit[temp * 2] = visit[temp] + 1;
                queue.add(temp * 2);
            }
        }
        return -1;
    }
}
