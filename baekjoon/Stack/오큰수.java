package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                array[stack.pop()] = array[i];
            }
            stack.push(i); //인덱스를 저장
        }

        while (!stack.isEmpty()) {
            array[stack.pop()] = -1;
        }

        for (int a : array) {
            sb.append(a).append(' ');
        }
        System.out.println(sb.toString());

        /** 완전탐색은 시간초과
         int[] result = new int[n];
         Arrays.fill(result, -1);
         for (int i = 0; i < n - 1; i++) {
         int temp = array[i];
         for (int j = i + 1; j < n; j++) {
         if (array[j] > temp) {
         result[i] = array[j];
         break;
         }
         }
         }

         for (int a : result) {
         sb.append(a).append(' ');
         }

         System.out.println(sb.toString());
         **/
    }
}
