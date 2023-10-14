package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); //25114

        if(s.charAt(0)=='0') { // 시작이 0이면 잘못된 암호
            System.out.println("0");
            return;
        }

        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) { //자릿수 결정
            char ch = s.charAt(i - 1); //현재 체크하는 문자
            char prev = s.charAt(i - 2); //앞의 문자

            if (ch == '0') { //현재 문자가 0이라면
                if (prev == '1' || prev == '2') {
                    dp[i] = dp[i - 2] % 1000000;
                } else { //1이나 2가 아니라면 잘못된 문자열
                    break;
                }
            } else {
                if (prev == '0') { //앞 문자가 0이라면
                    dp[i] = dp[i - 1] % 1000000; //뒤 문자도 경우의 수 변화 없음
                } else { //앞의 문자가 0이 아니고, 현재 문자도 0이 아니라면
                    int temp = (prev - '0') * 10 + (ch - '0');
                    if (1 <= temp && temp <= 26) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    } else { //두 수가 26을 초과하면
                        dp[i] = dp[i - 1] % 1000000;
                    }
                }
            }
        }
        System.out.println(dp[s.length()] % 1000000);
    }
}
