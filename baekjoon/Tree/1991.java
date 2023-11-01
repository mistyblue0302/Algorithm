import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //노드 개수
        tree = new int[26][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            //A = 65, . = 46
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            tree[parent][0] = (left == -19) ? -1 : left; //만약 트리 왼쪽이 비었다면 -1 저장
            tree[parent][1] = (right == -19) ? -1 : right; //트리 오른쪽이 비었다면 -1 저장
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
        if (node == -1) {
            return;
        }
        sb.append((char) (node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    public static void inOrder(int node) {
        if (node == -1) {
            return;
        }
        inOrder(tree[node][0]);
        sb.append((char) (node + 'A'));
        inOrder(tree[node][1]);
    }

    public static void postOrder(int node) {
        if (node == -1) {
            return;
        }
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        sb.append((char) (node + 'A'));
    }
}
