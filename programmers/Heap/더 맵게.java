import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>(); // 3  5 9 10 12, 오름차순
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
       
        while(true) {
            if(queue.size() == 1 && queue.peek() < K) return -1;
            if(queue.peek() >= K) break;
            
            int first = queue.poll();
            int second = queue.poll();
            
            int mix = first + (second * 2);
            queue.add(mix);
            answer++;
        }
        
        return answer;
    }
}
