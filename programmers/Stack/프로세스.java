import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 자료의 삽입과 삭제가 빈번 -> linkedlist를 활용 : 시간복잡도 O(1)
        // 인접한 참조만 관리하면 되기 때문에
        Queue<int[]> queue = new LinkedList<>(); // 프로세스 정보와 위치 정보 같이 저장
        int index = 0;
        for(int p : priorities) {
            queue.add(new int[] {p, index++});
        }
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll(); // [3, 2]
            boolean flag = false;
            
            for(int[] q : queue) {
                if(temp[0] < q[0]) { // 우선순위가 더 높은 프로세스가 있다면
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                queue.add(temp);
            } else {
                answer++;
                if(location == temp[1]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
