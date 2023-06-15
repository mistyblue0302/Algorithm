import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] levelMin; //각 레벨의 최소 x좌표
    public static int[] levelMax; //각 레벨의 최대 x좌표
    public static List<Node> tree = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static int point = 1; //현재 x좌표로 노드를 방문할 때마다 1 증가

    public static int max = 0; //트리의 최대 깊이

    public static class Node {

        int parent; //부모 번호
        int num; //자신의 번호
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.parent = -1; //루트가 1부터 시작 하지 않기 때문에 각 노드마다 parent를 초기화한다.
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //19
        levelMin = new int[n + 1]; //레벨은 1부터 시작하니까 n+1
        levelMax = new int[n + 1];

        int rootIndex = 0;
        for (int i = 0; i <= n; i++) {
            tree.add(new Node(i, -1, -1));
            levelMin[i] = n; //레벨의 최소 좌표
            levelMax[i] = 0; //레벨의 최대 좌표
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken()); //1
            int left = Integer.parseInt(st.nextToken()); //2
            int right = Integer.parseInt(st.nextToken()); //3
            tree.get(num).left = left;
            tree.get(num).right = right;
            if (left != -1) {
                tree.get(left).parent = num;
            }
            if (right != -1) {
                tree.get(right).parent = num;
            }
        }

        //parent를 처음에 -1로 초기화시켜주었기 때문에, -1을 그대로 가지고 있는 노드가 루트노드
        for (int i = 1; i <= n; i++) {
            if (tree.get(i).parent == -1) {
                rootIndex = i;
                break;
            }
        }

        inOrder(rootIndex, 1);

        // 완성된 levelMax[]와 levelMin[]을 가지고 값을 뽑아내기
        int answerLevel = 1;
        int answerWidth = levelMax[1] - levelMin[1] + 1;
        for (int i = 2; i <= max; i++) {
            int width = levelMax[i] - levelMin[i] + 1;
            if (answerWidth < width) {
                answerLevel = i;
                answerWidth = width;
            }
        }
        System.out.println(answerLevel + " " + answerWidth);
    }

    //중위 순회를 하면 방문하는 순서 그대로가 각 노드의 x좌표
    public static void inOrder(int rootIndex, int level) {
        Node node = tree.get(rootIndex);
        if (max < level) { //트리의 최대 깊이가 레벨보다 작으면 갱신
            max = level;
        }
        if (node.left != -1) { //왼쪽
            inOrder(node.left, level + 1);
        }
        //현재 노드가 가장 왼쪽 노드라면 갱신
        levelMin[level] = Math.min(levelMin[level], point);
        //현재 노드는 이전노드보다 항상 x좌표가 크기 때문에 갱신
        levelMax[level] = point;
        point++; //point : 현재 x좌표
        if (node.right != -1) { //오른쪽
            inOrder(node.right, level + 1);
        }

    }
}
