import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>(); 
        int sum = 0; // 다리에 올라간 트럭들의 무게
        int time = 0; // 1
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i]; // 4
            while(true) {
                if(queue.isEmpty()) { // 다리에 트럭이 없을 때
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if(sum + truck > weight) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}
