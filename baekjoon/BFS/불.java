package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {

    static int r, c;
    static char[][] array;
    static boolean[][] visited;
    static boolean[][] fireVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        array = new char[r][c];
        visited = new boolean[r][c];
        fireVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                array[i][j] = s.charAt(j);
                if (array[i][j] == 'J') {
                    queue.add(new int[]{i, j});
                    array[i][j] = '.';
                    visited[i][j] = true;
                } else if (array[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                    fireVisited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            int size2 = fire.size();

            for(int i = 0; i < size2; i++) {
                int[] temp = fire.poll(); //불
                int x = temp[0];
                int y = temp[1];

                for (int j = 0; j < 4; j++) { //불이 움직이는 위치(벽이 있는 공간은 통과하지 못한다.)
                    int cx = x + dx[j];
                    int cy = y + dy[j];
                    if (cx < 0 || cx >= r || cy < 0 || cy >= c || fireVisited[cx][cy]
                        || array[cx][cy] == '#') {
                        continue;
                    }
                    fireVisited[cx][cy] = true;
                    array[cx][cy] = 'F';
                    fire.add(new int[]{cx, cy});
                }
            }

            for(int i = 0; i < size; i++) {
                int[] temp2 = queue.poll();
                int x2 = temp2[0];
                int y2 = temp2[1];
                for (int k = 0; k < 4; k++) { //지훈이가 움직이는 위치(벽이 있는 공간은 통과하지 못한다.)
                    int cx = x2 + dx[k];
                    int cy = y2 + dy[k];
                    if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
                        time++;
                        System.out.println(time);
                        System.exit(0);
                    }

                    if (array[cx][cy] != '.' || visited[cx][cy]) {
                        continue;
                    }
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy});
                }
            }
            time++;
        }
    }
}

