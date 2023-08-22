package BFS;

import java.util.*;

class 전력망을둘로나누기 {
    static int[][] array;

    public int solution(int n, int[][] wires) {
        int answer = n;
        array = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            array[a][b] = 1;
            array[b][a] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0]; //1
            int b = wires[i][1]; //3
            array[a][b] = 0;
            array[b][a] = 0; //전력망을 하나씩 끊어보기
            answer = Math.min(answer, bfs(n, a));
            array[a][b] = 1;
            array[b][a] = 1;
        }
        return answer;
    }

    public static int bfs(int n, int first) { //9 1
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(first);
        visited[first] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll(); //1
            for (int i = 1; i <= n; i++) {
                if (array[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }

        return (int) Math.abs(count - (n - count));
    }
}
