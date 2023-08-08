package DFS;

import java.util.Scanner;

public class 바이러스 {

    static int n;
    static int m;
    static int array[][];
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //1
            int b = sc.nextInt(); //2
            array[a][b] = array[b][a] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int index) {
        visited[index] = true;

        for (int i = 1; i <= n; i++) {
            if (array[index][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}

