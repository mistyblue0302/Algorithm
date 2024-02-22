package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         * 양수 : 1의 경우 곱하지 않고 따로 더해준다.
         * 음수 및 0 : 절대값이 큰 순서대로 곱해서 더한다.
         */
        PriorityQueue<Integer> over = new PriorityQueue<>(Collections.reverseOrder()); // 양수 저장(내림차순)
        PriorityQueue<Integer> under = new PriorityQueue<>(); // 음수 저장(오름차순)

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                under.add(num);
            } else {
                over.add(num);
            }
        }

        int result = 0;
        while(!over.isEmpty()) {
            int current = over.poll();

            if(over.isEmpty()) { // 마지막 남은 값일 때 그냥 결과에 더해주기
                result += current;
                break;
            }

            if(current == 1) { // 현재 값이 1일 때 곱하지 말고 더해주기
                result += 1;
            } else if(over.peek() == 1) { // 다음 값도 1일 때
                result += current + over.poll();
            } else {
                result += current * over.poll();
            }
        }

        while(!under.isEmpty()) {
            int current = under.poll();

            if(under.isEmpty()) {
                result += current;
                break;
            }

            if(under.peek() == 0) {
                under.poll();
            } else {
                result += current * under.poll();
            }
        }
        System.out.println(result);
    }
}
