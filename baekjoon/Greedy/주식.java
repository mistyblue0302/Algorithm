package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] array = new int[day];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < day; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int current = array[day - 1];
            for (int k = array.length - 2; k >= 0; k--) {
                int num = array[k];
                if (num < current) {
                    sum += current - num;
                } else {
                    current = num;
                }
            }
            System.out.println(sum);
        }
    }
}
