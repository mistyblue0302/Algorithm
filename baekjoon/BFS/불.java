package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {

    static int t;
    static int w, h;
    static char[][] array;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            array = new char[h][w];
            visited = new boolean[h][w];

            Queue<int[]> queue = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    array[i][j] = s.charAt(j);
                    if (array[i][j] == '@') {
                        queue.add(new int[]{i, j, 0}); //시작 지점을 큐에 저장
                    } else if (array[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            }

            int result = bfs(queue, fire);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int bfs(Queue<int[]> queue, Queue<int[]> fire) {
        while (!queue.isEmpty()) {
            //불을 퍼뜨리기
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] temp = fire.poll();
                int x = temp[0];
                int y = temp[1];

                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];

                    if (cx >= 0 && cx < h && cy >= 0 && cy < w && array[cx][cy] == '.') {
                        array[cx][cy] = '*';
                        fire.add(new int[]{cx, cy});
                    }
                }
            }

            //상근이 이동
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                int time = temp[2];

                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];

                    if (cx < 0 || cx >= h || cy < 0 || cy >= w) { //밖을 벗어났다면
                        return time + 1; //탈출 성공, 0초에서 시작했기 때문에 + 1
                    }

                    if (array[cx][cy] == '.' && !visited[cx][cy]) { //빈공간이고 방문하지 않았다면
                        visited[cx][cy] = true; //방문 처리를 해줘야 최단 거리를 구할 수 있다.
                        queue.add(new int[]{cx, cy, time + 1});
                    }
                }
            }
        }

        return -1; // 탈출 실패
    }
}

