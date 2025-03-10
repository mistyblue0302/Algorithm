import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 몇 초 걸리는지
        
        Queue<Integer> queue = new LinkedList<>(); 
        int w = 0; // 다리에 올라간 트럭들의 무게
         
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i]; 
            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    w += truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    w -= queue.poll();
                } else {
                    if(w + truck > weight) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(truck);
                        time++;
                        w += truck;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
