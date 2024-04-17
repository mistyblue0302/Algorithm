package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 일반 배열의 순회는 O(n)의 시간복잡도
        // 이분 탐색은 O(logn)
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int a = Arrays.binarySearch(array, num);
            if(a < 0) {
                sb.append(0).append('\n');
            } else {
                sb.append(1).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
