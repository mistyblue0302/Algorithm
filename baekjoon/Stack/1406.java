import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); //abcd

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        //명령어 수행 전 커서의 위치는 문장의 맨 뒤
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            switch (s.charAt(0)) {
                case 'L':
                    if (leftStack.isEmpty()) {
                        break;
                    }
                    rightStack.push(leftStack.pop());
                    break;

                case 'D':
                    if (rightStack.empty()) {
                        break;
                    }
                    leftStack.push(rightStack.pop());
                    break;

                case 'B':
                    if(leftStack.empty()) break;
                    leftStack.pop();
                    break;

                case 'P':
                    leftStack.push(s.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
