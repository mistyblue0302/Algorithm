package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] roadLength = new long[n - 1];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < roadLength.length; i++) {
            roadLength[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < price.length; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long cost = price[0] * roadLength[0]; //10
        long min = price[0]; //5
        for (int i = 1; i < roadLength.length; i++) {
            min = Math.min(price[i], min); //2
            cost += roadLength[i] * min;
        }
        System.out.println(cost);
    }
}
