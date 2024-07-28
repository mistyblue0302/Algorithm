import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                queue.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
        // 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
        int first = queue.poll(); // 7
        int count = 1;
        while(!queue.isEmpty()) {
            if(first >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                list.add(count);
                count = 1;
                first = queue.poll();
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
