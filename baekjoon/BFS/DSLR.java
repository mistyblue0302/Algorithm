package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000]; //BFS 탐색의 방문 여부 체크
            String[] command = new String[10000]; //정답 명령어를 담는 배열

            queue.add(a); //a를 큐에 담고
            visited[a] = true; //방문 표시한다
            Arrays.fill(command, "");

            while (!queue.isEmpty() && !visited[b]) {
                int now = queue.poll(); //현재 탐색 위치

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    queue.add(D); //큐에 넣는다
                    visited[D] = true; //방문처리
                    command[D] = command[now] + "D"; //명령어 추가
                }

                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }

                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }
}
