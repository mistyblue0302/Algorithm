package Heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 국회의원선거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n명
        int dasom = Integer.parseInt(br.readLine()); //다솜이의 득표수
        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        if (n != 1) {
            while (queue.peek() >= dasom) {
                int temp = queue.poll();
                temp--;
                count++;
                dasom++;
                queue.offer(temp);
            }
        }

        System.out.println(count);
    }
}
