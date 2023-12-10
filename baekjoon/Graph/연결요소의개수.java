package Graph;

import java.util.Scanner;

public class 연결요소의개수 {

    public static int n;
    public static int m;
    public static int array[][];
    public static boolean visited[];
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //정점의 개수
        m = sc.nextInt(); //간선의 개수
        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //간선의 양 끝점
            int b = sc.nextInt(); //간선의 양 끝점
            array[a][b] = array[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i <= n; i++) {
            if (array[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
