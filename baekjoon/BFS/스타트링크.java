package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {

    static int F, S, G, U, D;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken()); //100
        S = Integer.parseInt(st.nextToken()); //2
        G = Integer.parseInt(st.nextToken()); //1
        U = Integer.parseInt(st.nextToken()); //1
        D = Integer.parseInt(st.nextToken()); //0

        visited = new int[F + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = 1;

        bfs(queue);
    }

    public static void bfs(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int temp = queue.poll(); //1

            if (temp == G) {
                System.out.println(visited[temp] - 1); //1부터 시작했기 때문에 빼준다.
                return;
            }

            //두 개의 if문이 독립적으로 실행되기 때문에 두 가지 조건을 모두 체크하고 처리(버튼 수의 최솟값이므로)
            if (temp + U <= F && visited[temp + U] == 0) { //F층보다 작거나 낮고, temp + U층을 방문하지 않았다면(그 층을 한번이라도 방문했다면 최단 거리가 아니다.)
                visited[temp + U] = visited[temp] + 1;
                queue.add(temp + U);
            }
            if (temp - D > 0 && visited[temp - D] == 0) { //0층보다 높고, temp - D층을 방문하지 않았다면
                visited[temp - D] = visited[temp] + 1;
                queue.add(temp - D);
            }
        }

        if (visited[G] == 0) {
            System.out.println("use the stairs");
        }
    }
}
