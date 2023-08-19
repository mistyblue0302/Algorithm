import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

    static int r, c;
    static char[][] array;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<int[]> queue = new LinkedList<>(); //고슴도치 위치
    static Queue<int[]> water = new LinkedList<>(); //물의 위치
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        array = new char[r][c];
        //비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*',
        // 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                array[i][j] = s.charAt(j);
                if (array[i][j] == 'S') {
                    queue.offer(new int[]{i, j, 0});
                } else if (array[i][j] == '*') {
                    water.offer(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    public static void bfs() { //고슴도치는 다음 시간에 물이 찰 예정인 칸으로 이동할 수 없으므로 물 먼저 계산해준다.
        while (!queue.isEmpty()) {
            int size = water.size();
            for (int i = 0; i < size; i++) {
                int temp[] = water.poll();
                int x = temp[0];
                int y = temp[1];
                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];
                    if (cx >= 0 && cx < r && cy >= 0 && cy < c && array[cx][cy] == '.') {
                        array[cx][cy] = '*';
                        water.add(new int[]{cx, cy});
                    }
                }
            }

            size = queue.size(); //고슴도치 이동
            for (int i = 0; i < size; i++) {
                int temp[] = queue.poll();
                int x = temp[0];
                int y = temp[1];
                int time = temp[2];
                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];
                    if (cx >= 0 && cx < r && cy >= 0 && cy < c) {
                        if (array[cx][cy] == 'D') {
                            answer = Math.min(answer, time + 1);
                            return;
                        } else if (array[cx][cy] == '.') {
                            array[cx][cy] = 'S';
                            queue.add(new int[]{cx, cy, time + 1});
                        }
                    }
                }
            }
        }
    }
}

