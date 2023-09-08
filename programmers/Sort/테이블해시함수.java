package Sort;

import java.util.*;

class 테이블해시함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //동일하면 첫 번째 컬럼 기준 내림차순, 동일하지 않다면 col번째 컬럼 기준 오름차순
        Arrays.sort(data, (o1, o2) -> {
            return (o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1]);
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int row : data[i]) { //2 2 6
                sum += (row % (i + 1));
            }
            answer = answer ^ sum;
        }

        return answer;
    }
}
