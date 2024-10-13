package Heap;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; 
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        
        for(int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            if(str[0].equals("I")) {
                minQueue.add(Integer.parseInt(str[1]));
                maxQueue.add(Integer.parseInt(str[1]));
                continue;
            } else if(str[0].equals("D")) {
                if(str[1].equals("1")) {
                    minQueue.remove(maxQueue.poll());
                    continue;
                } else if(str[1].equals("-1")) {
                    maxQueue.remove(minQueue.poll());
                    continue;
                }
            }
        }
        
        if(minQueue.size() == 0 && maxQueue.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        return answer;
    }
}
