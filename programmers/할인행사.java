import java.util.*;

class 할인행사 { //원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - days + 1; i++) { //열흘 간의 기준이기 때문에 끝까지 비교를 해주지 않아도 된다.
            Map<String, Integer> map2 = new HashMap<>();

            for (int j = 0; j < days; j++) {
                map2.put(discount[i + j], map2.getOrDefault(discount[i + j], 0) + 1);
            }

            Boolean flag = true;
            for (String key : map.keySet()) {
                if (map.get(key) != map2.get(key)) { //map에서 key값으로 가져온 값과 map2에서 key로 가져온 값이 다르면
                    flag = false;
                    break;
                }
            }
            answer += flag ? 1 : 0; //가능할 때마다 일수를 더해준다.
        }
        return answer;
    }
}
