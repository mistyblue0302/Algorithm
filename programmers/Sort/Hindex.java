package Sort;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); 
        int left = 0; 
        int right = citations.length; 
        
        while(left <= right) { // left가 right를 넘어설 때까지 탐색
            int mid = (left + right) / 2; 
            int count = 0; 
            
            for(int citation : citations) {
                if(citation >= mid) {
                    count++;  
                }
            }
            
            if(count >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}
