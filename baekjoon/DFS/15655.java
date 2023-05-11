import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int m;
    public static int array[];
    public static boolean visit[];
    public static int result[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //n개의 자연수 중
        m = Integer.parseInt(st.nextToken()); //m개를 고른 수열, 오름차순, 중복 x

        array = new int[n]; //4
        visit = new boolean[n]; //4
        result = new int[m]; //2

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int at) { //at : 시작점

        if (depth == m) {
            for (int answer : result) {
                sb.append(answer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = array[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
