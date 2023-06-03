import java.util.*;

class Main {

    private static int n;
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};
    private static int sum = 0; //총 단지수
    private static int count;
    private static int[][] array;
    private static boolean[][] visited;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //지도의 크기
        array = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (!visited[i][j] && array[i][j] == 1) {
                    count++;
                    sum++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        System.out.println(sum);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (!visited[cx][cy] && array[cx][cy] == 1) {
                    count++;
                    dfs(cx, cy);
                }
            }
        }
    }
}

