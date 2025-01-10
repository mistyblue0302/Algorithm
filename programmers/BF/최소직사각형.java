import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0;
        int length = 0;
        for(int i = 0; i < sizes.length; i++) {
            int a = Math.max(sizes[i][0], sizes[i][1]); // 70 
            int b = Math.min(sizes[i][0], sizes[i][1]); // 30
            
            width = Math.max(width, a);
            length = Math.max(length, b);
        }
        return width * length;
    }
}
