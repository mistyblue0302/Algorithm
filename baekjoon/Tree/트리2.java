package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리2 {

    static List<Integer>[] list;
    static int delete;
    static int root;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
            } else {
                list[node].add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());
        if (delete == root) {
            System.out.println(0);
            return;
        } else {
            dfs(root);
        }
        System.out.println(result);
    }

    public static void dfs(int v) {

        int nodes = 0;
        for (int a : list[v]) {
            if (a != delete) {
                nodes++;
                dfs(a);
            }
        }
        if (nodes == 0) {
            result++;
        }
    }
}