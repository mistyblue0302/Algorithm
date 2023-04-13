class Solution {
    int N;
    int min;
    int[][] map;
    int[] visit;
    
    public int dfs(int n) {
        visit[n] = 1;
        int child = 1;
        for(int i =1; i<= N; i++){
            if(visit[i] == 0 && map[n][i] == 1) {
                visit[i] = 1;
                child += dfs(i);
            }
        }
        min = Math.min(min, Math.abs(child - (N-child)));
        return child;
    }
    
    public int solution(int n, int[][] wires) {
        N = n; //송전탑의 개수
        min = n;
        map = new int[n+1][n+1];
        visit = new int[n+1];
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
}
