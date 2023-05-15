import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static int n;
    public static int array[];
    public static boolean visit[];
    public static int result[];
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visit = new boolean[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            max = Math.max(max, getResult());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = array[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static int getResult() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(result[i] - result[i + 1]);
        }
        return sum;
    }
}
