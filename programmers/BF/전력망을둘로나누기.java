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
            int a = wires[i][0]; 
            int b = wires[i][1];
            array[a][b] = 0; // 연결 끊기
            array[b][a] = 0;
            answer = Math.min(answer, bfs(n, a));
            array[a][b] = 1;
            array[b][a] = 1;
        }
        return answer;
    }
    
    public int bfs(int n, int a) {
        boolean[] visited = new boolean[n + 1];
        int count = 1; // 전력망 개수
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        
        while(!queue.isEmpty()) {
            int temp = queue.poll(); 
            for(int i = 0; i <= n; i++) {
                if(array[temp][i] == 1 && !visited[i]) {
                    count++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return (int) Math.abs(count - (n - count));
    }
}
