package Simulation;

class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;
        int pick = 0;

        //택배 양과 수거 양이 capacity를 초과하면 빼준다.
        //초과하면( > 0) capacity만큼 빼주고, 거리를 * 2하여 저장.
        for(int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pick += pickups[i];
            while(delivery > 0 || pick > 0) {
                delivery -= cap;
                pick -= cap;
                answer += (i + 1) * 2;
            }
        }
        return answer;
    }
}
