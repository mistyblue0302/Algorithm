package Sort;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); 
        
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int remain = n - i;  // 남은 논문 개수
            
            // 남은 논문 중에서 인용 횟수가 h번 이상인 경우 찾기
            if (citations[i] >= remain) {
                return remain;  
            }
        }
        
        return 0;  // 조건을 만족하지 않는 경우
    }
}
