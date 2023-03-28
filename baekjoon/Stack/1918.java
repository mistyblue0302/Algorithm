import java.io.*;
import java.util.Stack;

public class Main {

    public static int priority(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                bw.write(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    bw.write(stack.pop());
                }
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(s.charAt(i))) {
                    // 스택이 비어 있지 않고 스택 상단 값의 우선순위가 입력 문자보다 크면
                    // 괄호안이 아니고 stack 최상단 값이 * 나 /면
                    bw.write(stack.pop());
                    // 스택 상단 값 출력
                }
                stack.add(s.charAt(i));
                // 다시 담는다
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
    }
}
