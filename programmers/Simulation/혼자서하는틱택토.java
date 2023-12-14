package Simulation;

class Solution {

    static char[][] ch;

    public int solution(String[] board) {
        int answer = 1;
        ch = new char[3][3];

        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ch[i][j] = board[i].charAt(j);
                if (ch[i][j] == 'O') {
                    countO++;
                }
                if (ch[i][j] == 'X') {
                    countX++;
                }
            }
        }

        if (countX > countO) { //X가 O보다 많거나, O가 2개이상 많을 경우
            return 0;
        }
        if (countO - countX >= 2) {
            return 0;
        }

        //O가 완성되었을 때 X와 O가 같은 경우
        if (dfs('O')) {
            if (countX == countO) {
                return 0;
            }
        }

        //X가 완성되었을 때 O가 X보다 많은 경우
        if (dfs('X')) {
            if (countO - countX > 0) {
                return 0;
            }
        }

        return answer;
    }

    public boolean dfs(char c) {
        //가로
        for (int i = 0; i < 3; i++) {
            if (ch[i][0] == c && ch[i][1] == c && ch[i][2] == c) {
                return true;
            }
        }

        //세로
        for (int i = 0; i < 3; i++) {
            if (ch[0][i] == c && ch[1][i] == c && ch[2][i] == c) {
                return true;
            }
        }

        //대각선
        if (ch[0][0] == c && ch[1][1] == c && ch[2][2] == c) {
            return true;
        }

        if (ch[0][2] == c && ch[1][1] == c && ch[2][0] == c) {
            return true;
        }
        return false;
    }
}
