package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회장뽑기 {

    static int n;
    static int count = 0;
    static int[] result;
    static boolean[] visited;
    static List<Integer> list[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            list[a].add(b);
            list[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result[i] = bfs(i);
            min = Math.min(min, result[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == min) {
                sb.append(i).append(' ');
                count++;
            }
        }
        System.out.println(min - 1 + " " + count);
        System.out.println(sb.toString());
    }

    public static int bfs(int start) {
        visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int a : list[temp]) {
                    if (visited[a]) {
                        continue;
                    }
                    visited[a] = true;
                    queue.add(a);
                }
            }
            count++;

        }
        return count;
    }
}
