import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s;

        // 커서를 이동할때마다 스택끼리 값을 옮겨줌
        Stack<Character> stack = new Stack<>(); //앞의 문자열
        Stack<Character> stack2 = new Stack<>(); //뒤의 문자열

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '<') {
                    if (!stack.isEmpty())
                        stack2.push(stack.pop());
                } else if (s.charAt(j) == '>') {
                    if (!stack2.isEmpty())
                        stack.push(stack2.pop());
                } else if (s.charAt(j) == '-') {
                    if (!stack.isEmpty())
                        stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            while (!stack2.isEmpty())
                stack.push(stack2.pop());

            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty())
                sb.append(stack.pop());

            bw.write(sb.reverse() + "\n");
        }
        br.close();
        bw.close();
    }
}

