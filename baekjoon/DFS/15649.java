import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static int m;	
    public static int[] array;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m]; //출력할 배열
        visit = new boolean[n]; //들렸던 노드를 체크하는 배열

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int val : array) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i =0 ; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
