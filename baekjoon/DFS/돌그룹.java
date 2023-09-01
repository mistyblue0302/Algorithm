package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 돌그룹 {

    static int a, b, c;
    static int result = 0;
    static boolean[][] visted = new boolean[1501][1501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if ((a + b + c) % 3 != 0) {
            System.out.println(0);
        } else {
            dfs(a, b, c);
            System.out.println(result);
        }
    }

    public static void dfs(int a, int b, int c) {
        if (a == b && b == c) {
            result = 1;
            return;
        }

        calc(a, b, c);
        calc(a, c, b);
        calc(b, c, a);
    }

    public static void calc(int a, int b, int origin) {
        int min = Math.min(a, b); //10
        int max = Math.max(a, b); //15

        //숫자를 이전에 만든 적이 있는지 체크
        if (!visted[min * 2][max - min]) {
            visted[min * 2][max - min] = visted[max - min][min * 2] = true;
            dfs(min * 2, max - min, origin);
        }
    }
}
