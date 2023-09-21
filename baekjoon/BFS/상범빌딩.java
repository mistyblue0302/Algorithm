package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {
    static char array[][][];
    static int distance[][][];
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_x = 0;
            int start_y = 0;
            int start_z = 0;

            int end_x = 0;
            int end_y = 0;
            int end_z = 0;

            int L = Integer.parseInt(st.nextToken()); //층수
            int R = Integer.parseInt(st.nextToken()); //행
            int C = Integer.parseInt(st.nextToken()); //열

            if (L == 0 && R == 0 && C == 0) //입력의 끝
                break;

            array = new char[L][R][C];
            distance = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        if (s.charAt(k) == 'S') { //시작 지점
                            start_x = j;
                            start_y = k;
                            start_z = i;
                        }
                        if (s.charAt(k) == 'E') { //탈출구
                            end_x = j;
                            end_y = k;
                            end_z = i;
                        }
                        array[i][j][k] = s.charAt(k);
                    }
                }
                br.readLine();
            }

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{start_z, start_x, start_y}); //시작 지점의 층수, 행, 열 저장

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                int z = temp[0];
                int x = temp[1];
                int y = temp[2];

                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;

                    if (array[nz][nx][ny] == '#' || distance[nz][nx][ny] != 0) continue; //막혀있어 지나갈 수 없거나 이미 방문한 경우

                    q.offer(new int[]{nz, nx, ny});
                    distance[nz][nx][ny] = distance[z][x][y] + 1;
                }

            }

            int ans = distance[end_z][end_x][end_y];

            if (ans == 0)
                System.out.println("Trapped!");
            else {
                System.out.println("Escaped in " + ans + " minute(s).");
            }
        }
    }
}
