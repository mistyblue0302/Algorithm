package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    public static int n;
    public static int[] operator = new int[4]; //연산자 개수
    public static int[] number;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //3
        number = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index) {

        if (index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + number[index], index + 1);
                        break;
                    case 1:
                        dfs(num - number[index], index + 1);
                        break;
                    case 2:
                        dfs(num * number[index], index + 1);
                        break;
                    case 3:
                        dfs(num / number[index], index + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
