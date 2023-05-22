import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int count;
    public static int[][] array;
    public static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visit = new boolean[n];
        count = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n / 2; i++) { //팀이 한 명 이상이기만 하면 되기 때문에 1명부터 시작하여 총 팀원 수의 반까지 올려준다.
            dfs(0, 0);
            count++;
        }

        System.out.println(min);

    }

    public static void dfs(int depth, int at) {
        if (depth == count) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visit[i] == true && visit[j] == true) {
                        start += array[i][j] + array[j][i];
                    } else if (visit[i] == false && visit[j] == false) {
                        link += array[i][j] + array[j][i];
                    }
                }
            }
            int temp = Math.abs(start - link);
            min = Math.min(min, temp);
            if (min == 0) {//min값이 0이면 더이상 작은 값이 없으므로 0을 출력 후 코드를 끝낸다.
                System.out.println(min);
                System.exit(0);
            }

        } else {
            for (int i = at; i < n; i++) {
                if (visit[i] == false) {
                    visit[i] = true;
                    dfs(depth+1, i + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
