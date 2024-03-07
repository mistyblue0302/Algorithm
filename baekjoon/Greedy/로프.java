package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 로프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array, Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * (i + 1) > answer) {
                answer = array[i] * (i + 1);
            }
        }
        System.out.println(answer);
    }
}
