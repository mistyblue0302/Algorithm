import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int n;
    public static int result = 0;
    public static int array[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //7
        array = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken()); //일 수
            array[i][1] = Integer.parseInt(st.nextToken()); //이익
       }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int day, int pay) {
        if (day >= n) {
            result = Math.max(pay, result);
            return;
        }

        if (day + array[day][0] <= n) { //상담을 마칠 수 있다면
            dfs(day + array[day][0], pay + array[day][1]);
        } else { //상담을 마칠 수 없다면 -> 상담이 끝난 날짜만 넘겨준다
            dfs(day + array[day][0], pay);
        }
        dfs(day + 1, pay);
    }
}
