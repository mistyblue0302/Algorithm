package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회사문화1 {

    static int n, m;
    static List<Integer> list[];
    static int[] array;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        array = new int[n + 1];
        answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) {
                list[num].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            array[num] += value;
        }

        dfs(1, 0);

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void dfs(int current, int sum) {
        sum += array[current];
        answer[current] = sum;

        for (int child : list[current]) {
            dfs(child, sum);
        }
    }
}
