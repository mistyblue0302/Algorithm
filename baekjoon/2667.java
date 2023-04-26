import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n; //지도 크기
    static int map[][];
    static boolean visited[][];

    static int count; //해당 단지에 속한 집의 수
    static int result; //총 단지수
    static List<Integer> list = new ArrayList<>(); //각 단지에 속하는 집의 수

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //7

        map = new int[n][n];
        visited = new boolean[n][n];

        //입력
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        //탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (map[i][j] == 1 && !visited[i][j]) {
                    result++;
                    count++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        System.out.println(result);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
