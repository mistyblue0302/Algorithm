import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0) {
            list.add(n % 3);
            n /= 3;
        }
        
        int temp = 1;
        for(int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * temp;
            temp *= 3;
        }
        
        return answer;
    }
}
