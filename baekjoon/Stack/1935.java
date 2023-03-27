import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //알파벳 개수 : 5
        String s = br.readLine();  //후위 표기식 : ABC*+DE/-

        double[] array = new double[n]; //알파벳의 개수 만큼 배열을 만든다.

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        //스택에 피연산자(알파벳)를 넣고 연산자가 나오면 값을 빼 연산 후 결과를 다시 스택에 넣음
        Stack<Double> stack = new Stack<>();
        double result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') { //영문일 경우는 스택에 push
                stack.push(array[s.charAt(i) - 'A']);
            } else {
                if (!stack.isEmpty()) { //연산자의 경우는 계산을 하고 push
                    double a = stack.pop();
                    double b = stack.pop();
                    switch (s.charAt(i)) {
                        case '+':
                            result = b + a;
                            stack.push(result);
                            break;
                        case '-':
                            result = b - a;
                            stack.push(result);
                            break;
                        case '*':
                            result = b * a;
                            stack.push(result);
                            break;
                        case '/':
                            result = b / a;
                            stack.push(result);
                            break;
                    }
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
