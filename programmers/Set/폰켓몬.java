import java.util.*;

class Solution {
    public int solution(int[] nums) { 
        
        int answer = 0; 
        
        int a = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for(int s : nums) {
            set.add(s);
        }
        
        if(a < set.size()) {
            answer = a;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}
