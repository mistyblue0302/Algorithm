import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            int value = priorities[i];
            queue.add(new int[]{value, i});
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll(); // [3, 2]
            boolean flag = false;
            
            for(int[] q : queue) {
                if(q[0] > current[0]) { // 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                queue.add(current);
            } else {
                count++;
                if(current[1] == location) {
                    answer = count;
                    break;
                }
            }
        }
        return answer;
    }
}
