import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int start = 0;
        Arrays.sort(nums); 

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != start) {
                break;
            } else {
                start++;
            }
        }
        return start;
    }
}
