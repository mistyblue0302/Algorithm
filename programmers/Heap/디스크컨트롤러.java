import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 우선 시작시간이 빠른 순으로 정렬  0,3  1,9  2,6
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
       
        // 시작시간이 같다면 작업시간이 짧은 것부터
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1]
        );
        
        int count = 0; // 처리한 작업 수
        int sum = 0; // 총 대기시간
        int end = 0; // 현재 시간
        int index = 0; // 배열의 인덱스
        while(count < jobs.length) {
            // 현재 시간에서 시작할 수 있는 작업을 큐에 추가
            while (index < jobs.length && jobs[index][0] <= end) {
                queue.add(jobs[index++]);
            }
            
            if(queue.isEmpty()) {
               end = jobs[index][0]; 
            } else {
                int[] temp = queue.poll(); 
                sum += end + temp[1] - temp[0]; 
                end += temp[1];
                count++;
            }
        }
        return sum / count;
    }
}
