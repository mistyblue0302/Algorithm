import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int tree[][];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //알파벳에서 'A'를 빼면 숫자
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            //A = 65, . = 46으로 만약 비어있다면 46-65 = -19가 나와야 한다.
            tree[parent][0] = (left == -19) ? -1 : left;
            tree[parent][1] = (right == -19) ? -1 : right;
        }
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);;
        System.out.println(sb.toString());
    }

    public static void preOrder(int x) {
        if (x == -1) {
            return;
        }
        sb.append((char) (x + 'A')); //항상 A가 루트 노드가 되기 때문에
        preOrder(tree[x][0]); //왼쪽 자식 호출
        preOrder(tree[x][1]); //오른쪽 자식 호출
    }

    public static void inOrder(int x) {
        if (x == -1) {
            return;
        }
        inOrder(tree[x][0]);
        sb.append((char) (x + 'A'));
        inOrder(tree[x][1]);
    }

    public static void postOrder(int x) {
        if (x == -1) {
            return;
        }
        postOrder(tree[x][0]);
        postOrder(tree[x][1]);
        sb.append((char)(x + 'A'));
    }
}
