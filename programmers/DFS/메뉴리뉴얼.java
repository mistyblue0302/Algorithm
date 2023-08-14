package DFS;

import java.util.*;

class 메뉴리뉴얼 {
    static List<String> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        //오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }

        //orders를 기준으로 course 길이 만큼의 조합 만들기
        for (int courses : course) {
            for (String order : orders) {
                combination("", order, courses);
            }
        }

        //orders를 기준으로 course 길이 만큼의 조합 만들기
        for (int courses : course) {
            for (String order : orders) {
                combination("", order, courses); //먼저 조합을 다 만들고
            }
            //가장 많은 조합 저장
            if (!map.isEmpty()) { //조합이 하나라도 만들어 졌다면
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                if (max > 1) { //최소 2명 이상의 손님으로부터 주문된 메뉴인지 판단하고 리스트에 추가한다.
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            list.add(key);
                        }
                    }
                }
                map.clear(); //그 다음 courses로 넘어가서 조합을 만든다.
            }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void combination(String order, String others, int count) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
        }

        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
