import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int count = 0;

        Arrays.sort(lottos);
        for(int i = 0; i < lottos.length; i++) { //0의 개수를 센다.
            if(lottos[i] != 0) {
                break;
            }
            count++;
        }

        Arrays.sort(win_nums);
        for(int i = 0; i < lottos.length; i++) {
            for(int j = count; j < win_nums.length; j++) {
                if(win_nums[i] != lottos[j]) {
                  continue; //다음 증감식으로 이동
                }
                answer[0]++;
                answer[1]++;
            }
        }

        answer[0] += count;

        for(int i = 0; i < 2; i++) {
            if(answer[i] == 6) {
                answer[i] = 1;
            } else if(answer[i] == 5) {
                 answer[i] = 2;
            } else if(answer[i] == 4) {
                answer[i] = 3;
            } else if(answer[i] == 3) {
                answer[i] = 4;
            } else if(answer[i] == 2){
                answer[i] = 5;
            } else {
                answer[i] = 6;
            }
        }

        return answer;
    }
}
