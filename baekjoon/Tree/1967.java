import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    //지름 : 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이, 두 노드를 선택해서 양쪽으로 당길 때, 가장 길게 늘어나는 경우

    public static int n;
    public static ArrayList<int[]> list[];
    public static boolean visit[];
    public static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //노드의 개수
        list = new ArrayList[n + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new int[]{child, weight});
            list[child].add(new int[]{parent, weight});
        }

        for (int i = 1; i < list.length; i++) {
            visit = new boolean[n + 1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int n, int distance) {
        visit[n] = true;
        max = Math.max(max, distance);

        for (int array[] : list[n]) {
            if (!visit[array[0]]) {
                dfs(array[0], distance + array[1]);
            }
        }
    }
}
