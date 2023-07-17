package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken()); //1부터 N까지 큐에 있어야 함
        int M = Integer.parseInt(st.nextToken()); //뽑아내려는 수의 개수

        int result = 0; //2번과 3번 연산 횟수의 누적 합

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] array = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int target = deque.indexOf(array[i]); //2
            int half;

            if (deque.size() % 2
                == 0) { //deque의 원소가 짝수 개수라면 {0,1,2,3} 중간 지점을 deque의 절반 크기에서 -1 감소시킨다.
                half = deque.size() / 2 - 1;
            } else {
                half = deque.size() / 2;
            }

            if (target <= half) { //중간지점 또는 중간 지점보다 원소가 앞에 있을 경우
                for (int j = 0; j < target; j++) {
                    int temp = deque.pollFirst(); //앞의 원소 추출
                    deque.offerLast(temp);
                    result++;
                }
            } else {
                for (int j = 0; j < deque.size() - target; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    result++;
                }
            }
            deque.pollFirst(); //연산이 끝나면 맨 앞의 원소를 삭제
        }
        System.out.println(result);
    }
}
