import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine() + "\n"; //I am happy today

            for (char c : s.toCharArray()) {
                if (c == ' ' || c == '\n') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(c);
                } else {
                    stack.push(c);
                }
            }
            bw.flush(); //남아있는 데이터를 모두 출력
        }
    }
}
