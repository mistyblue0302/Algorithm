package BF;

class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;
        int pick = 0;

        //delivery와 pick을 따로 카운팅, 끝에서부터 하나라도 0을 초과하면(물류창고로 가야하므로) -cap을 해주면
        //물류창고 전까지 얼만큼 배달, 수거할 수 있는지 알 수 있다.
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
