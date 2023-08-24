import java.util.*;

class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long x = (long) d * d;
            long y = (long) i * i;
            int temp = (int) Math.sqrt(x - y);
            answer += (temp / k) + 1;
        }
        return answer;
    }
}
