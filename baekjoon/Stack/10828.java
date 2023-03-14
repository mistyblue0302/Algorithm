import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int stack[];
    public static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //명령의 수 n
        stack = new int[n];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " "); //push 1

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int x) {
        stack[size] = x;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int remain = stack[size - 1]; //가장 위에 있는 정수
            stack[size - 1] = 0;
            size--;
            return remain;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size != 0) {
            int top = stack[size - 1];
            return top;
        } else {
            return -1;
        }
    }
}
