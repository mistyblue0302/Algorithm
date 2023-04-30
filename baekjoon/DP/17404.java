import java.util.Scanner;

public class Main {
    public static int MAX = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //3

        int[][] house = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        int result = Integer.MAX_VALUE;

        // 첫번째집 색상, 마지막집 색상을 지정한후 나머지 연산(가운데의 최소비용계산) 진행한다.
        for (int i = 0; i < 3; i++) { //첫번째집 색상
            for (int j = 0; j < 3; j++) { //마지막집 색상
                if (i == j) continue;

                init(dp);
                dp[0][i] = house[0][i];

                for (int x = 1; x < n; x++) {
                    for (int y = 0; y < 3; y++) {
                        dp[x][y] = Math.min(dp[x - 1][(y + 1) % 3] + house[x][y], dp[x - 1][(y + 2) % 3] + house[x][y]);
                    }
                }

                result = Math.min(result, dp[n - 1][j]);
            }
        }

        System.out.println(result);
    }

    public static void init(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = MAX;
            }
        }
    }
}
