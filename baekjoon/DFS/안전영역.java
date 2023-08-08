package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 안전영역 {

    static int n;
    static int[][] array;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    //내리는 비의 양에 따른 모든 경우를 다 조사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];

        int max = 0; //최대 얼마만큼의 비가 내릴 수 있는지
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }

        for (int i = 1; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (array[j][k] >= i && !visited[j][k]) {
                        count++;
                        dfs(j, k, i);
                    }
                }
            }
            list.add(count);
            for(boolean b[] : visited) { //다음 계산을 위해 초기화
                Arrays.fill(b, false);
            }
        }
        int result = Collections.max(list);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int rain) {
        visited[x][y] = true;

        for(int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < array.length && ny < array.length) {
                if(array[nx][ny] >= rain && !visited[nx][ny])
                    dfs(nx,ny, rain);
            }
        }
    }
}

