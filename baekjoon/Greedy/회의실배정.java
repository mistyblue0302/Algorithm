package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); //시작
            time[i][1] = Integer.parseInt(st.nextToken()); //종료
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) { //종료 시간이 같으면
                return o1[0] - o2[0]; //시작 시간이 빠른 순으로
            }
            return o1[1] - o2[1]; //종료 시간 빠른 순
        });

        int end = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(end <= time[i][0]) {
                end = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
