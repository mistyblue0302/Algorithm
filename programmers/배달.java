class 배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int max = 500000; //배달 가능 시간의 최대
        int[][] cost = new int[N + 1][N + 1]; //마을의 개수만큼 생성
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                cost[i][j] = max;
            }
            cost[i][i] = 0;
        }

        for(int i = 0; i < road.length; i++) {
            int current = road[i][0];
            int arrive = road[i][1];
            int time = road[i][2];
            cost[current][arrive] = Math.min(cost[current][arrive], time);
            cost[arrive][current] = Math.min(cost[arrive][current], time);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] +  cost[i][k]); //j부터 k까지 갈 때 j가 i를 경유
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(cost[1][i] <= K) answer++;
        }
        return answer;
    }
}
