package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //도감에 수록된 포켓몬 수
        int m = Integer.parseInt(st.nextToken()); //내가 맞춰야 하는 문제 수

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(i, s);
            map2.put(s, i);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (isNumber(s)) {
                String temp = map.get(Integer.parseInt(s));
                System.out.println(temp);
            } else {
                int number = map2.get(s);
                System.out.println(number);
            }
        }

    }
    public static boolean isNumber(String s) { //숫자인지 확인하기
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}