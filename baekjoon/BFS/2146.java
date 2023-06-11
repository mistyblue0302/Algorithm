import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] array;
    public static int[][] group;
    public static int[][] distance;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        array = new int[n][n];
        group = new int[n][n]; //섬의 번호가 매겨져 저장된 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1 && group[i][j] == 0) {
                    dfs(i, j, ++count);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 1; i<=count; i++){
            answer = Math.min(answer, bfs(i, n));
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int cnt) {
        group[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (array[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx, ny, cnt);
                }
            }
        }
    }

    public static int bfs(int cnt, int n) { //섬 번호가 cnt일 때, 나머지 섬들에 다리를 놓을때의 최단 거리
        Queue<int[]> queue = new LinkedList<>();
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //현재 섬의 번호가 cnt일때는 0, 바다 일때는 -1, 다른 섬일 때는 -2
                if (group[i][j] == cnt) {
                    distance[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else if (group[i][j] == 0) {
                    distance[i][j] = -1;
                } else {
                    distance[i][j] = -2;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (distance[nx][ny] == -2) { //cnt번째 섬에서 다른 섬을 만났을 때의 분기
                        min = Math.min(min, distance[x][y]);
                        //continue;
                    } else if (distance[nx][ny] == -1) { //바다를 만났을 때
                        queue.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }

        return min;
    }
}


