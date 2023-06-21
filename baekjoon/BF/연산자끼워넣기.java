package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    public static int n;
    public static int[] array;
    public static int[] operator;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(array[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int depth) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(num + array[depth], depth + 1);
                        break;
                    case 1:
                        dfs(num - array[depth], depth + 1);
                        break;
                    case 2:
                        dfs(num * array[depth], depth + 1);
                        break;
                    case 3:
                        dfs(num / array[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}