import java.util.*;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int[] num = new int[10000001];
        int answer = 0;
        for (int n : tangerine) {
            num[n]++;
        }
        Arrays.sort(num);

        for (int i = 10000000; i >= 0; i--) {
            if (num[i] >= k) {
                answer++;
                break;
            } else {
                k -= num[i];
                answer++;
            }
        }
        return answer;
    }
}
