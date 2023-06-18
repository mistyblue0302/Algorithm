package BF;

import java.util.Arrays;
import java.util.Scanner;

public class 단어수학 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            String s = sc.next(); //AAA
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                // 자릿수만큼 10의 거듭제곱 더해준다
                alphabet[c - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }

        Arrays.sort(alphabet);

        int num = 9;

        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) {
                continue;
            }
            answer += (alphabet[i] * num); //큰 수 부터 9,8,7,...
            num--;
        }
        System.out.println(answer);
    }
}
