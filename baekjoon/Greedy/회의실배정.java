package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 회의실배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의실 최대 개수
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 끝나는시간
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {  // 끝나는 시간이 같다면 시작시간 오름차순
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1]; // 끝나는 시간 오름차순
        });

        int end = 0; // 현재 회의 끝나는 시간
        int count = 0; // 회의의 최대 개수

        for (int i = 0; i < time.length; i++) {
            if (end <= time[i][0]) { // 다음 회의의 시작시간이 현재 끝나는 시간과 같거나 후라면
                count++;
                end = time[i][1];
            }
        }

        System.out.println(count);
    }
}
