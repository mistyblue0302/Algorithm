import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int array[][];
    static int min = Integer.MAX_VALUE;
    static boolean visit[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);

    }

    public static void dfs(int start, int i, int count, int sum) {
        if (count == n && start == i) {
            min = Math.min(min, sum);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (array[i][j] == 0) {
                continue;
            }

            if (!visit[i] && array[i][j] > 0) {
                visit[i] = true;
                sum += array[i][j];
                dfs(start, j, count + 1, sum);
                visit[i] = false;
                sum -= array[i][j];
            }
        }
    }
}
