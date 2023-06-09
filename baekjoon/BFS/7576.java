import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main { //최소 일수 : bfs

    private static int n, m;
    private static int tomato[][];
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};
    private static int day = 0;
    private static int count = 0;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        tomato = new int[n][m];

        //1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 없는 곳
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomato[i][j] = sc.nextInt();
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j}); //x,y좌표를 큐에넣음
                } else if (tomato[i][j] == 0) {
                    count++;
                }
            }
        }

        dfs();
        System.out.println(count == 0 ? day : -1);
    }

    private static void dfs() {
        while (!queue.isEmpty() && count > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] array = queue.poll(); //x,y좌표를 꺼내서 해당 인덱스의 상하좌우를 체크
                int x = array[0];
                int y = array[1];

                for (int j = 0; j < 4; j++) {
                    int cx = x + dx[j];
                    int cy = y + dy[j];

                    if (cy < 0 || cx < 0 || cy >= m || cx >= n || tomato[cx][cy] != 0) {
                        continue;
                    }

                    count--;
                    tomato[cx][cy] = 1; //익은 토마토(1)로 변경. visit으로 방문 처리를 하지 않아도 됨.
                    queue.add(new int[]{cx, cy}); //해당 인덱스를 큐에 추가
                }
            }
            day++;
        }
    }
}

