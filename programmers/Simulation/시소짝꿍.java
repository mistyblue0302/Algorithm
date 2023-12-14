package Simulation;

import java.util.*;

class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights); //100 100 180 270 360

        //정렬했기 때문에 뒤로갈수록 큰 값만 오게되므로 2/3일때, 2/4일 때, 3/4일 때만 고려해준다.
        for(int i = 0; i < weights.length; i++) {
            double weight = weights[i];
            double w1 = weight * 1.0;
            double w2 = (weight * 1.0) / 2.0;
            double w3 = (weight * 2.0) / 3.0;
            double w4 = (weight * 3.0) / 4.0;
            if(map.containsKey(w1)) answer += map.get(w1);
            if(map.containsKey(w2)) answer += map.get(w2);
            if(map.containsKey(w3)) answer += map.get(w3);
            if(map.containsKey(w4)) answer += map.get(w4);
            map.put(w1, map.getOrDefault((w1), 0) + 1);
        }
        return answer;
    }
}
