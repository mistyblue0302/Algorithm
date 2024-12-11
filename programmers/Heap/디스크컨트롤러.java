import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업 시작 시간이 빠른것부터 
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 시작시간이 같다면 작업시간이 짧은 것부터
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1]
        );
        
        int time = 0; // 현재 시간
        int sum = 0; // 총 반환시간
        int index = 0; // jobs 인덱스
        int completedJobs = 0; // 완료된 작업 수
        while(completedJobs < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index]);
                index++;
            }
            
            if(queue.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] current = queue.poll();
                time += current[1]; 
                sum += time - current[0];
                completedJobs++;
            }
        }
        return sum / jobs.length;
    }
}
