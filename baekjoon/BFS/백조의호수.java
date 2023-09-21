package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {

    static int r, c;
    static char[][] array;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> swan = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        array = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                array[i][j] = s.charAt(j);
                if (array[i][j] == 'L') { //백조는 오직 물 공간에서 세로나 가로로만(대각선은 제외한다) 움직일 수 있다.
                    swan.add(new int[]{i, j}); //백조 위치 저장
                }

                //if : 빙판이 아니고 물이면(백조가 있는 곳도 물이기 때문에 카운트 해주려면 else if x)
                //백조가 L에 있을수도 있고 물 공간에서 움직일 수 있다고 했기 때문에 조건을 빙판이 아닌 곳이라고 둔다.
                if (array[i][j] != 'X') {
                    water.add(new int[]{i, j}); //물 위치 저장
                }
            }
        }

        int[] first = swan.poll(); //탐색할 큐에 첫 번째 백조를 넣고 방문 체크
        int x = first[0];
        int y = first[1];
        visited[x][y] = true;
        queue.add(new int[]{x, y}); //탐색 큐

        int[] second = swan.poll();
        int resultX = second[0];
        int resultY = second[1];

        int day = 0;
        boolean meet = false;
        while (true) {
            Queue<int[]> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                x = now[0];
                y = now[1];

                if (x == resultX && y == resultY) {
                    meet = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    if (cx < 0 || cx >= r || cy < 0 || cy >= c || visited[cx][cy]) {
                        continue;
                    }

                    visited[cx][cy] = true;
                    if (array[cx][cy] == 'X') { //빙판이라면 next 큐에 넣는다.
                        next.add(new int[]{cx, cy}); //next 큐에 들어간 지역들은 다음 날 얼음이 녹아 다음 탐색의 시작점이 된다.
                        continue;
                    }
                    queue.add(new int[]{cx, cy}); //빙판이 아니라면 탐색 가능 큐에 넣는다.
                }
            }

            if (meet) { //만났다면 종료
                break;
            }

            queue = next; //만약 탐색 큐를 다 탐색했는데도 만나지 못했다면, 다음 날 탐색 할 지역이 담긴 큐로 바꾼다.
            int size = water.size(); //얼음을 녹인다
            for (int i = 0; i < size; i++) {
                int[] now = water.poll();
                x = now[0];
                y = now[1];

                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];

                    if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
                        continue;
                    }

                    if (array[cx][cy] == 'X') { //물이 녹았고, 물에 인접한 빙판을 발견하면 녹이고 큐에 넣는다.
                        array[cx][cy] = '.'; //물이 녹았으므로 물 공간으로 처리
                        water.add(new int[]{cx, cy});
                    }
                }
            }
            day++; //매일 물 공간과 접촉한 모든 빙판 공간은 녹는다. 물이 녹을 때 day를 카운팅
        }
        System.out.println(day);
    }
}

