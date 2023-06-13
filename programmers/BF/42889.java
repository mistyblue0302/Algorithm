import java.util.HashMap;

import java.util.*;

class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        HashMap<Integer, Double> map = new HashMap<>();

        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            // 실패한 사람 수 세기 위한 카운트 변수 선언
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) { // 값이 같으면 카운트
                    cnt++;
                }
            }
            if (cnt == 0) { // 0은 나눌 수 없으므로 0이면 map에 0 넣음
                map.put(i, (double) 0);
                continue;
            }
            // 실패율 계산해서 map에 넣기
            map.put(i, (double) cnt / (double) length);
            length = length - cnt;
        }

        List<Integer> list = new ArrayList<>(map.keySet()); //key값으로 리스트 만들기
        // 실패율 내림차순 정렬(오름차순 일때는 (map.get(o1).compareTo(map.get(o2))));
        Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int i = 0;
        for (Integer key : list) {
            answer[i] = key;
            i++;
        }

        return answer;
    }
}
