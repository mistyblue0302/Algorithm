package BF;

import java.util.*;

class Solution {
    
    int[][] array;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        array = new int[n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            array[a][b] = 1;
            array[b][a] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0]; // 1
            int b = wires[i][1]; // 3
            array[a][b] = 0;
            array[b][a] = 0; // 전력망을 하나씩 끊어보기
            answer = Math.min(answer, bfs(a, n));
            array[a][b] = 1;
            array[b][a] = 1;
        }
        return answer;
    }
    
    public int bfs(int node, int n) {
        boolean[] visited = new boolean[n + 1];
        int count = 1; // 전력망 개수 : 초기값 1
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
            int temp = queue.poll(); // 1
            for(int i = 0; i <= n; i++) {
                if(array[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        
        return (int) Math.abs(count - (n - count));
    }
}
