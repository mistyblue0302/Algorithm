package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선긋기 {

    static class Line implements Comparable<Line> {

        int x, y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) { // 현재 객체의 x 좌표와 매개변수로 들어오는 다른 객체의 x 좌표를 비교
            // 먼저 x 좌표를 기준으로 오름차순으로 정렬하고, x 좌표가 동일한 경우에는 y 좌표를 기준으로 내림차순으로 정렬
            if (this.x == o.x) {
                return o.y - this.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Line> queue = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        int x = queue.peek().x;
        int y = queue.peek().y;
        queue.poll();
        while (!queue.isEmpty()) {
            Line current = queue.poll(); // 6 7
            if (current.x > y) {
                sum += y - x; //2
                x = current.x;
                y = current.y;
                continue;
            }
            y = Math.max(y, current.y);
        }
        System.out.println(sum + y - x);
    }
}