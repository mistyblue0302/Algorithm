package Heap;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>(); //오름차순 정렬
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            queue.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = queue.poll(); //2
            long y = queue.poll(); //3
            queue.offer(x + y);
            queue.offer(x + y);
        }

        long score = 0;
        for (int i = 0; i < n; i++) {
            score += queue.poll();
        }
        System.out.println(score);
    }
}
