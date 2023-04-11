import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) { //카펫의 가로, 세로 크기를 리턴
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i =3; i <sum; i++){
            int j = sum / i;
            if(sum % i == 0 && j>=3) {
                int column = Math.max(i,j);
                int row = Math.min(i,j);
                int center = (column-2) * (row-2);
                
                if(center == yellow) {
                    answer[0] = column;
                    answer[1] = row;
                    
                }
            }
        }
        return answer;
    }
}
