package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] array;
    public static boolean[][] visit;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        array = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int row, int column) {
        if (row == n) {    //마지막 행에 도달하면 해당 경우의 가로와 세로의 합을 구한다.
            sum();
            return;
        }
        if (column == m) {    //해당 열이 true, false 표시가 완료되면 다음 행으로 넘어간다.
            dfs(row + 1, 0);
            return;
        }
        visit[row][column] = true;    //가로로 잘랐을 때, 다음 열로 넘어간다.
        dfs(row, column + 1);

        visit[row][column] = false;   //세로로 잘랐을 때, 다음 열로 넘어간다.
        dfs(row, column + 1);
    }

    private static void sum() {
        int sum = 0; //하나의 경우의 가로와 세로 숫자의 합

        for (int i = 0; i < n; i++) { //가로 합, 행을 기준으로 탐색
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) { //visit 값이 true인 경우는 가로 숫자에 해당
                    temp *= 10; //자릿수
                    temp += array[i][j];
                } else { //세로 숫자
                    sum += temp; //이전까지 구해진 가로 숫자를 더하고 temp 초기화
                    temp = 0;
                }
            }
            sum += temp; //하나의 행이 모두 가로라면 더해준다.
        }

        for (int i = 0; i < m; i++) { //세로 합, 열을 기준으로 탐색
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (!visit[j][i]) { //visited 값이 false인 경우는 세로 숫자에 해당
                    temp *= 10;
                    temp += array[j][i];
                } else {
                    sum += temp; //이전까지 구해진 세로 숫자를 더하고 temp 초기화
                    temp = 0;
                }
            }
            sum += temp; //하나의 열이 모두 세로숫자라면 더해준다.
        }
        max = Math.max(max, sum); //최대값 갱신
    }
}

