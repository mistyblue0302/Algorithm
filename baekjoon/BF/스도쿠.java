package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠 {

    public static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int column) {
        if (column == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(array[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        //해당 위치가 0이라면 1~9 까지 사용 가능한 값을 탐색한다
        if (array[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, column, i)) {
                    array[row][column] = i;
                    sudoku(row, column + 1);
                }
            }
            array[row][column] = 0;
            return;
        }
        sudoku(row, column + 1);
    }

    public static boolean possibility(int row, int column, int value) {
        //같은 행에 있는 원소들 중 겹치는 원소가 있는지
        for (int i = 0; i < 9; i++) {
            if (array[row][i] == value) {
                return false;
            }
        }

        //같은 열에 있는 원소들 중 겹치는 원소가 있는지
        for (int i = 0; i < 9; i++) {
            if (array[i][column] == value) {
                return false;
            }
        }

        //3*3 칸에 겹치는 원소가 있는지(0,3,6 중 하나) -> [0][0], [0][3], [0][6], [3][0], [3][3], [3][6], [6][0], [6][3], [6][6]
        int setRow = (row / 3) * 3;
        int setCol = (column / 3) * 3;

        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (array[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
