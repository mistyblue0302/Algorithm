import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) { 
        Queue<Integer> queue = new LinkedList<>(); //다리
        int time = 0;
        int sum = 0; //무게
        
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i]; //6
            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    time++;
                    sum += truck;
                    break;
                } else if(queue.size() == bridge_length) {
		    sum -= queue.poll();
		} else {
                    if(truck + sum > weight) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(truck);
                        time++;
                        sum += truck;
                        break;
                    }
                }
            }
        }
        return time + bridge_length; //마지막 역시 다리 길이만큼 지나가야하기때문에 + 다리 길이
    }
}
