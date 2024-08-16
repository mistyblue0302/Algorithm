import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0); // 현재 피로도, 던전, 탐험할 수 있는 던전 수
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) { // 현재 피로도가 던전의 최소 필요 피로도보다 같거나 크다면
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
