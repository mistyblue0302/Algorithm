import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums); // 0 1 3
        int n = nums[nums.length - 1]; // n : 3

        int number = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != number) {
                break;
            } else {
                number++;
            }
        }
        return number;
    }
}
