package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    static int n, m;
    static List<Integer> list[];
    static boolean[] visited;
    static int[][] array;
    static int min = Integer.MAX_VALUE;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        array = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i); //i부터 모든 경우 탐색
        }

        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); //시작점과 베이컨 수
        visited[start] = true;

        int sum = 0; //수마다 단계의 합
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int num = temp[0]; //시작점
            int depth = temp[1]; //베이컨수
            sum += depth;

            for (int a : list[num]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(new int[]{a, depth + 1});
                }
            }
        }

        if (sum < min) {
            min = sum;
            result = start;
        }
    }
}
