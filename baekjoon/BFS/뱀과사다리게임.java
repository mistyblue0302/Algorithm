package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] count;
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = new int[101];
        //사다리
        int n = Integer.parseInt(st.nextToken());
        //뱀
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        bfs();
        System.out.println(count[100]);
    }


    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp > 100) {
                break;
            }
            for (int i = 1; i < 7; i++) {
                int newPos = temp + i;
                if (newPos <= 100 && !visited[newPos]) {
                    if (map.containsKey(newPos)) {    // 사다리 또는 뱀
                        if (!visited[map.get(newPos)]) {
                            visited[map.get(newPos)] = true;
                            count[map.get(newPos)] += count[temp] + 1;
                            queue.add(map.get(newPos));
                        }
                    } else {
                        visited[newPos] = true;
                        queue.add(newPos);
                        count[newPos] += count[temp] + 1;
                    }
                }
            }
        }
    }
}

