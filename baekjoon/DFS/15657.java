import java.util.*;

class Main {

    public static int n;
    public static int m;
    public static int array[];
    public static int result[];

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n개의 자연수 : 4
        m = sc.nextInt(); //m개를 고른 수열 : 2

        array = new int[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int at) {
        if (depth == m) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            result[depth] = array[i];
            dfs(depth + 1, i);
        }
    }
}
