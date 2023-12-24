import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프 {

    static int k;
    static int v, e;
    static List<Integer> list[];
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken()); //정점의 개수
            e = Integer.parseInt(st.nextToken()); //간선의 개수
            list = new ArrayList[v + 1];
            visited = new int[v + 1];

            //그래프 초기화
            for (int j = 1; j <= v; j++) {
                list[j] = new ArrayList<>();
            }


            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            if (bfs()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) { //처음 단계에서 1번 방문처리
                queue.add(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int a : list[now]) {
                    if (visited[a] == visited[now]) {
                        return false;
                    }

                    if (visited[a] == 0) { //방문하지 않았다면
                        queue.add(a);
                        visited[a] = visited[now] * -1; //반대 색으로 칠하기
                    }
                }
            }
        }
        return true;
    }
}









