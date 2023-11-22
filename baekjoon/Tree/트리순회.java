import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {

    static int n;
    static int[][] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[26][2];

        //A = 65, . = 46
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            array[node][0] = (left == -19) ? -1 : left;
            array[node][1] = (right == -19) ? -1 : right;
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');
        System.out.println(sb.toString());
    }

    public static void preOrder(int node) {
        if (node == -1) return;
        sb.append((char) (node + 'A'));
        preOrder(array[node][0]); //실행하고 아래 문장 실행
        preOrder(array[node][1]);
    }

    public static void inOrder(int node) {
        if (node == -1) return;
        inOrder(array[node][0]);
        sb.append((char) (node + 'A'));
        inOrder(array[node][1]);
    }

    public static void postOrder(int node) {
        if (node == -1) return;
        postOrder(array[node][0]);
        postOrder(array[node][1]);
        sb.append((char) (node + 'A'));
    }
}
