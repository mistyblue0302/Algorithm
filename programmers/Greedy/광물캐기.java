package Greedy;

import java.util.*;

class 광물캐기 {

    static int[][] array;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        //리스트를 돌 곡괭이를 사용했을 때의 피로도(최악의 경우)를 기준으로 내림차순 정렬
        //"돌로 캤을때 가장 많은 비용이 드는" 섹션을 다이아몬드 곡괭이로 파야한다.
        int cnt = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        array = new int[cnt][3]; //5개씩 묶었을 때 광물별 피로도


        //곡괭이 개수만큼만 세기 -> 어차피 곡괭이 수가 부족하면 뒤에 있는 광물은 못 캠.
        for (int i = 0; i < minerals.length; i += 5) {
            if (i / 5 == cnt) {
                break;
            }
            //다이아몬드 곡괭이로 캤을 때 각각 피로도의 합, 철 곡괭이로 캤을 때, 돌 곡괭이로 캤을 때
            int dia = 0, ir = 0, st = 0;
            for (int j = i; j < i + 5; j++) {

                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1;
                    ir += 5;
                    st += 25;
                } else if (m.equals("iron")) {
                    dia += 1;
                    ir += 1;
                    st += 5;
                } else {
                    dia += 1;
                    ir += 1;
                    st += 1;
                }

                if (j == minerals.length - 1) {
                    break;
                }
            }
            array[i / 5][0] = dia;
            array[i / 5][1] = ir;
            array[i / 5][2] = st;
        }

        //인덱스 2를 기준으로 내림차순, 즉 돌 피로도가 높은 순서대로 내림차순으로 정렬
        //돌 피로도가 높은 배열이 앞에 옴
        Arrays.sort(array, (o1, o2) -> (o2[2] - o1[2]));

        //다이아 -> 철 -> 돌 순서대로 캐기
        for (int i = 0; i < cnt; i++) {
            if (picks[0] != 0) {
                answer += array[i][0]; //다이아로 캤을 때 피로도
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += array[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += array[i][2];
                picks[2]--;
            }
        }

        return answer;
    }
}
