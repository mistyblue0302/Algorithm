package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {

    public static int N, K;
    public static boolean[] visit;
    public static int result = 0;
    public static String s[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        s = new String[N];

        visit = new boolean[26];
        visit['a' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['c' - 'a'] = true;

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            //anta와 tica 제거
            for (int i = 0; i < N; i++) {
                String str = br.readLine(); //antarctica
                s[i] = str.substring(4, str.length() - 4);
            }
            K -= 5; //antic 5개의 단어는 포함해야 하므로
            dfs(0, 0);
            System.out.println(result);
        }
    }

    public static void dfs(int start, int count) {
        if (count == K) {
            int num = 0;
            for (int i = 0; i < s.length; i++) {
                boolean flag = true;
                for (int j = 0; j < s[i].length(); j++) {
                    if (!visit[s[i].charAt(j) - 'a']) { //K개를 골랐을 때, 고른 단어로 해당 문자열을 읽을 수 있는지 판단
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    num++;
                }
            }
            result = Math.max(result, num);
            return;
        }

        //아직 K개를 배우지 않은 경우 -> 완전 탐색
        for (int i = start; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, count + 1);
                visit[i] = false;
            }
        }
    }
}
