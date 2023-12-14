package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오등큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] count = new int[1000000 + 1]; //수열에 등장한 횟수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            count[array[i]]++;
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>(); //인덱스 정보를 저장
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && count[array[stack.peek()]] < count[array[i]]) {
                result[stack.pop()] = array[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : result) {
            sb.append(a).append(' ');
        }
        System.out.println(sb.toString());
    }
}


