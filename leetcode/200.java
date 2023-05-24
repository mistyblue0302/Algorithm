public class Solution {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int row;
    public static int column;

    public int numIslands(char[][] grid) { //전체 섬의 개수를 리턴

        int result = 0;
        row = grid.length;
        column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int Row, int Column, char[][] grid) {
        grid[Row][Column] = '0';

        for (int k = 0; k < 4; k++) {
            int newX = dx[k] + Row; //인덱스
            int newY = dy[k] + Column;
            if (newX >= 0 && newX < row && newY >= 0 && newY < column
                && grid[newX][newY] == 1) {
                dfs(newX, newY, grid);
            }
        }
    }
}
