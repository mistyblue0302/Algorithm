import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int m;
    public static int array[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //1부터 n까지 자연수 중
        m = Integer.parseInt(st.nextToken()); //중복 없이 m개를 고른 수열, 오름차순

        array = new int[m];

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int depth, int at) { //at : 시작점 변수

        if (depth == m) {
            for (int result : array) {
                sb.append(result).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            array[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
