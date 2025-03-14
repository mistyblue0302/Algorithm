import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; // 초기 배열 [0,0]
        
        Queue<Integer> minQueue = new PriorityQueue<>(); // 오름차순
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" "); 
            int num = Integer.parseInt(s[1]);
            
            if(s[0].equals("I")) {
                maxQueue.add(num);
                minQueue.add(num);
            } else if(s[0].equals("D")) {
                if(minQueue.isEmpty() && maxQueue.isEmpty()) {
                    continue;
                } 
                
                if (num == 1) { 
                    minQueue.remove(maxQueue.poll()); 
                } else { 
                    maxQueue.remove(minQueue.poll()); 
                }
            }   
        }
        
        if(!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
    
        return answer;
    }
}
