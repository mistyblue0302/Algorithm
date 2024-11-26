import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length - 1] * (long)n; // 모든 사람이 심사를 받는데 걸리는 가장 오랜 심사시간
        
        while(left <= right) {
            long mid = (left + right) / 2; 
            long complete = 0;
            for(int i = 0; i < times.length; i++) {
                complete += mid / times[i]; // mid라는 시간동안 몇 명의 사람을 심사할 수 있는지 합산
            }
            
            if(complete < n) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
                answer = mid; 
            }
        }
        return answer;
    }
}
