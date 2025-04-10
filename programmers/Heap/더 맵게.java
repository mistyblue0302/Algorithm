import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.add(s);
        }
        
        while(true) {
            // 모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우
            if(queue.size() == 1 && queue.peek() < K) return -1;
            if(queue.peek() >= K) break;
            
            int a = queue.poll();
            int b = queue.poll();
            
            int mix = a + (b * 2);
            queue.add(mix);
            answer++;
        }
        
        return answer;
    }
}
