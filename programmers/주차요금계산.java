import java.util.*;

class 주차요금계산 {
    //주차 요금 = 기본 요금 + [(주차 누적시간 - 기본시간) / 단위 시간] * 단위 요금
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap<>(); //차량 번호가 작은 자동차부터
        for (String record : records) {
            String[] str = record.split(" ");
            String[] s = str[0].split(":");
            int time = (str[2].equals("IN") ? -1 : 1) * ((Integer.parseInt(s[0]) * 60) + Integer.parseInt(s[1]));
            String carNumber = str[1];
            map.put(carNumber, map.getOrDefault(carNumber, 0) + time);
        }

        int index = 0;
        int lastTime = 1439; //입차 후 출차기록이 없는 경우 23:59를 분으로 변환 하면 1439분
        int[] answer = new int[map.size()];
        for (String key : map.keySet()) {
            int time = map.get(key);
            time = time <= 0 ? time + lastTime : time; //입차 후 출차 기록이 없다면 23:59를 더해주고, 그게 아니라면 입차를 안한 것이므로 그대로 둔다.
            double baseTime = time <= fees[0] ? 0 : time - fees[0]; //누적 주차시간이 기본 시간 이하라면 추가로 낼 요금이 없으므로 0원 처리
            int price = fees[1] + (int) Math.ceil(baseTime / fees[2]) * fees[3];
            answer[index++] = price;
        }
        return answer;
    }
}
