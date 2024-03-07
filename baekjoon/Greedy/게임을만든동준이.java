package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n개의 레벨

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int current = Integer.MAX_VALUE;
        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (current > array[i]) {
                current = array[i];
            } else {
                while (array[i] >= current) {
                    array[i]--;
                    result++;
                }
                current = array[i];
            }
        }
        System.out.println(result);
    }
}