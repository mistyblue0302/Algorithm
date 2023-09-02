import java.util.*;

class 하노이의탑 {

    ArrayList<int[]> list = new ArrayList<>();;
    public int[][] solution(int n) {

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; ++i){
            int[] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }

        return answer;
    }

    public void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            list.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
