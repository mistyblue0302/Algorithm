package Heap;

import java.util.*;

import java.util.*;

class 디스크컨트롤러 {
    public int solution(int[][] jobs) { //SJF에 따라 작업이 짧을수록 먼저 배치되어야 평균 시간이 적어진다.
        int answer = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); //첫번째 숫자 기준 오름차순(하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리해야 하므로)
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //소요시간의 오름차순으로 정렬

        int count = 0;
        int sum = 0;
        int end = 0;
        int index = 0;
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= end) { //적은 시간이 걸리려면 시간이 겹치거나 end 바로 뒤에 와야한다.
                queue.add(jobs[index++]); //[0, 3]
            }

            //매 턴 마다 우선순위 큐에서 작업을 하나 씩 빼서 수행할때마다 end를 업데이트 한다. 모든 작업이 완료되면 평균을 구한다.
            if(queue.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] temp = queue.poll(); //{0, 3}
                sum += end + temp[1] - temp[0]; //앞의 작업이 끝난시점(end) + 다음 작업의 수행 시간 - 대기시간
                end += temp[1];
                count++;
            }
        }
        return sum / jobs.length;
    }
}