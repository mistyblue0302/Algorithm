import java.util.*;
import java.io.*;

public class 확장게임 {
    static int[][] array;
    static boolean[][] visited;
    static int[] player;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m, p;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m];
        player = new int[p + 1];
        result = new int[p + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            player[i] = Integer.parseInt(st.nextToken()); //player배열의 칸 만큼만 이동가능하다
        }

        Queue<int[]> queue[] = new LinkedList[p + 1];
        for (int i = 1; i <= p; i++) {
            queue[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == '#') { //벽이면 -1
                    array[i][j] = -1;
                } else if (ch == '.') { //빈 칸이면 0
                    array[i][j] = 0;
                } else { //성이라면 큐에 추가
                    array[i][j] = ch - '0';
                    queue[array[i][j]].add(new int[]{i, j});
                    result[array[i][j]]++; //가진 성의 수이므로 퍼져나가기 전 1개도 카운트
                }
            }
        }

        while (true) {
            for (int i = 1; i <= p; i++) {
                int count = 0;
                while (!queue[i].isEmpty()) {
                    int size = queue[i].size();
                    for (int j = 0; j < size; j++) {
                        int[] temp = queue[i].poll();
                        int x = temp[0];
                        int y = temp[1];
                        for (int k = 0; k < 4; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];
                            if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                            if (array[cx][cy] != 0) continue; //비어있는 칸이 아니라 움직일 수 없다면
                            result[i]++;
                            queue[i].add(new int[]{cx, cy});
                            array[cx][cy] = i;
                        }
                    }
                    count++;
                    if (count == player[i]) break;
                }
            }

            boolean flag = true; //모든 플레이어가 더 이상 확장을 할 수 없을 때 게임이 끝나기 때문에
            for (int i = 1; i <= p; i++) { //하나라도 큐가 비지 않은 플레이어가 있다면
                if (!queue[i].isEmpty()) flag = false;
            }
            if (flag) break; //큐가 모두 비어서 확장이 끝났다면 게임 종료
        }

        for (int i = 1; i <= p; i++) {
            System.out.print(result[i]);
            if (i != p) System.out.print(' ');
        }
    }
}
