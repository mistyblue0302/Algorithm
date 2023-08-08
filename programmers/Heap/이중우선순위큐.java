package Heap;

import java.util.*;

class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); //오름차순
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(s[1]));
                minQueue.offer(Integer.parseInt(s[1]));
            } else if(s[0].equals("D")) {
                if(s[1].equals("1")) {
                    minQueue.remove(maxQueue.poll());
                    continue;
                } else if(s[1].equals("-1")) {
                    maxQueue.remove(minQueue.poll());
                    continue;
                }
            }
        }

        if(maxQueue.size() == 0 && minQueue.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}