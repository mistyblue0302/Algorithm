package Heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        boolean isOdd = true;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isOdd) {
                max.add(num);
            } else {
                min.add(num);
            }

            //왼쪽 큐의 최대값이 오른쪽 큐의 최소값보다 크다면 자리교환
            if(!min.isEmpty() && max.peek() > min.peek() ) { //왼쪽 큐부터 들어가기 때문에 오른쪽 큐에 숫자가 있으면
                min.offer(max.poll());
                max.offer(min.poll());
            }

            //중간값은 왼쪽 큐 max에 존재
            sb.append(max.peek()).append('\n');
            isOdd = !isOdd;
        }
        System.out.println(sb);
    }
}
