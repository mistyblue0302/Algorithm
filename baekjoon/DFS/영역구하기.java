package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 영역구하기 {

    static int m, n, k;
    static int[][] array;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int size = 0;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int lastX = Integer.parseInt(st.nextToken());
            int lastY = Integer.parseInt(st.nextToken());
            for (int j = firstY; j < lastY; j++) {
                for (int k = firstX; k < lastX; k++) {
                    array[j][k] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 0) {
                    count = 0;
                    size++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        sb.append(size).append('\n');
        Collections.sort(list);
        for (int n : list) {
            sb.append(n).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int row, int column) {
        array[row][column] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int cx = row + dx[i];
            int cy = column + dy[i];
            if (cx >= 0 && cx < m && cy >= 0 && cy < n && array[cx][cy] == 0) {
                dfs(cx, cy);
            }
        }
    }
}








