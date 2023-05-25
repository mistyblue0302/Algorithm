import java.util.*;

public class Main {

    private static int[] array;
    private static int n; // 정수의 개수
    private static int s; // 정수의 합
    private static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        dfs(0, 0);

        if (s == 0) { //0일때가 전체 합이 0 일때랑 겹치기 때문에 -1을 해준다. 공집합이 0
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }

    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        
        dfs(depth + 1, sum + array[depth]);
        dfs(depth + 1, sum);
    }
}
