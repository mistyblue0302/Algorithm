package BF;

import java.util.*;

class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) { //크레인을 모두 작동시킨 후 터트러져 사라진 인형의 개수 int
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
         for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) { //인형이 있다면
                    if(stack.peek() == board[i][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move - 1]); 
                    }
                board[i][move - 1] = 0;
                break;
                }
            }
        }
        return answer;
    }
}
