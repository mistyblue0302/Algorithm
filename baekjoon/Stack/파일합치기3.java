package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                queue.offer(Long.parseLong(st.nextToken()));
            }

            Long sum = (long) 0;
            Long answer = (long) 0;
            while (queue.size() > 1) {
                Long a = queue.poll();
                Long b = queue.poll();
                sum = a + b;
                answer += sum;
                queue.add(sum);
            }
            System.out.println(answer);
        }
    }
}
