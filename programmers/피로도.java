class Solution {
    static boolean[] visited;
	static int answer = 0;
    
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		return solve(dungeons,k,visited,0);
	}
	
	private static int solve(int[][] dungeons, int k, boolean[] visited, int count){
		for(int i = 0; i < dungeons.length; i++){
			if(k >= dungeons[i][0] && !visited[i]){
				visited[i] = true;
				solve(dungeons,k - dungeons[i][1], visited, count + 1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, count);
		
		return answer;
	}
}
