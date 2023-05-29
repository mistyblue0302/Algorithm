import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int n;
    public static int k;
    public static boolean visit[];
    public static int array[];
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "0");
        System.out.println(set.size());
    }

    public static void dfs(int depth, String num) {
        if (depth == k) {
            set.add(num);
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, num + array[i]);
                visit[i] = false;
            }
        }
    }
}

