import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" "); 
            
            if(s[0].equals("I")) {
                minQueue.add(Integer.parseInt(s[1]));
                maxQueue.add(Integer.parseInt(s[1]));
            } else if(s[0].equals("D")) {
                if(s[1].equals("1")) {
                    minQueue.remove(maxQueue.poll());
                } else if(s[1].equals("-1")) {
                    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        if(maxQueue.size() == 0 && minQueue.size() == 0) {
            return answer;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
    
        return answer;
    }
}
