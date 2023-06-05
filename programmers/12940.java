import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int max = Math.max(n,m); //12
        int min = Math.min(n,m); //3
        
        //최대공약수
        while(min!=0) {
            int a = max % min;
            max = min;
            min = a;
        }
        
        //최소공배수 : 두수의 곱 / 최대공약수
        int gcd = (n * m) / max;
        
        int[] answer = {max, gcd};
        
        return answer;
    }
}
