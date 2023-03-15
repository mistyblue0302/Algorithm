import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        boolean flag = false; //<는 true, >는 false

        /**
         * < 전은 역순으로 출력, > 다음은 역순으로 출력
         */
        for (int i = 0; i < s.length(); i++) {
            // < 표시가 나왔을 때, stack이 비어있지 않다면 문자를 모두 꺼낸다.(뒤집는다)
            if (s.charAt(i) == '<') {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '>') { //> 저장
                flag = false;
                sb.append(s.charAt(i));
                continue; //증감식으로 이동
            }

            //태그 안의 문자열일 때
            if (flag == true) { // >를 만나기 전까지 그대로 입력
                sb.append(s.charAt(i));
            } else if (flag == false) { //태그 밖의 문자열일 때
                if (s.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
    }
}


