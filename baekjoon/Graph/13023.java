import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static boolean visited[];
    public static ArrayList<Integer> list[]; //인접한 리스트

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //사람의 수
        m = sc.nextInt(); //관계의 수
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(0, i); //각 노드 기준 dfs 탐색 시작
        }
        System.out.println(0); //dfs 탐색 후 규칙을 만족하지 않으면 0 출
    }

    public static void dfs(int depth, int idx) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visited[idx] = true;
        for (int i = 0; i < list[idx].size(); i++) { //연결된 범위까지
            int temp = list[idx].get(i);
            if(!visited[temp]) {
                visited[temp] = true;
                dfs(depth + 1, temp);
                visited[temp] = false;
            }
        }
    }
}
