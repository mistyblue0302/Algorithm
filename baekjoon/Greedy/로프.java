package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array); // 10 15

        int max = 0; // 최대 중량
        // 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량(모든 로프를 사용하지 않아도 됨)
        for (int i = array.length - 1; i >= 0; i--) {
            if (max < array[i] * (n - i)) {
                max = array[i] * (n - i);
            }
        }
        System.out.println(max);
    }
}
