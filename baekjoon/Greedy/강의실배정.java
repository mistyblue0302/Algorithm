package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강의실배정 {

    static class Assignment implements Comparable<Assignment> {

        int start;
        int end;

        public Assignment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Assignment assignment) {
            // 만약 시작시간이 같다면 종료시간을 기준으로 오름차순
            if (this.start == assignment.start) {
                return this.end - assignment.end;
            }
            // 시작시간이 다르다면 시작시간을 기준으로 오름차순
            return this.start - assignment.start;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Assignment> queue = new PriorityQueue<>();
        StringTokenizer st;
        // 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int classroom = 0;
        Queue<Integer> end = new PriorityQueue<>(); // 강의가 끝나는 시간을 저장 : 3 4
        while (!queue.isEmpty()) {
            Assignment assignment = queue.poll(); //1 3
            // 처음에 새로운 강의실을 배정하거나 전 수업이 마친 시간보다 다음 과제의 시작시간이 더 이른경우 강의실을 하나 더 배정
            if (end.isEmpty() || end.peek() > assignment.start) {
                classroom++;
            } else {
                end.poll();
            }
            end.add(assignment.end);
        }
        System.out.println(classroom);
    }
}
