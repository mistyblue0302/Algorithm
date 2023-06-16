import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //임의의 노드를 중심으로 가장 거리가 먼 노드를 찾고
    //그 노드에서 dfs를 돌려 가장 긴 트리의 지름을 구한다.

    public static int v;
    public static ArrayList<int[]> list[];
    public static boolean visit[];
    public static int max = 0;
    public static int far = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine()); //트리 정점의 개수
        list = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken()); //정점번호
            while (true) {
                int v2 = Integer.parseInt(st.nextToken()); //정점번호
                if (v2 == -1) {
                    break;
                }
                int num = Integer.parseInt(st.nextToken());
                list[v1].add(new int[]{v2, num});
            }
        }

        visit = new boolean[v + 1];
        dfs(1, 0); //임의의 정점 아무거나(이 문제에선 1로부터의 거리를 구한다.)

        visit = new boolean[v + 1];
        dfs(far, 0); //가장 멀리 있는 노드로부터 지름을 구한다.
        System.out.println(max);
    }

    public static void dfs(int n, int distance) {
        if (max < distance) {
            max = distance; //가장 긴 거리에 있는
            far = n; //노드를 찾는다.
        }

        visit[n] = true;
        for (int[] array : list[n]) {
            if (!visit[array[0]]) {
                dfs(array[0], distance + array[1]);
            }
        }
    }
}
