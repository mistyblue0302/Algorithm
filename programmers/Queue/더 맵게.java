import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 내림차순
        Queue<Integer> queue = new PriorityQueue<>(); // 기본 오름차순
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            if(queue.size() == 1) {
                return -1;
            }
            
            queue.add(queue.poll() + (queue.poll() * 2));
            answer++;
        }
        
        return answer;
    }
}
