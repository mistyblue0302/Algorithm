package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열사이클 {

    static int t;
    static int n;
    static boolean[] visited;
    static int[] array;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()); //2

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine()); //8
            count = 0;
            visited = new boolean[n + 1];
            array = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(st.nextToken()); //32781456(12345678 인덱스)
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int index) {
        if (!visited[array[index]]) {
            visited[array[index]] = true;
        } else {
            return;
        }
        dfs(array[index]);
    }
}