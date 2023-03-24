import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int result = 0; //쇠막대기 조각의 총 개수
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(') { //그 전 괄호가 열린 괄호면, 레이저를 의미하므로
                    result += stack.size(); //stack 사이즈를 더해준다.
                } else { //그 전 괄호가 닫힌 괄호면, 레이저가 아니다.
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
