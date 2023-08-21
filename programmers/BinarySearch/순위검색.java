package BinarySearch;

import java.util.*;

class 순위검색 {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
            makeQuery(s, 0, "");
        }

        for (String keys : map.keySet()) {
            Collections.sort(map.get(keys)); //점수 List를 오름차순 정렬
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] s = query[i].split(" "); //javabackendjuniorpizza , 150
            answer[i] = map.containsKey(s[0]) ? binarySearch(s[0], Integer.parseInt(s[1])) : 0;
        }
        return answer;
    }

    public static int binarySearch(String key, int score) { //score 점수 이상 받은 사람 이분 탐색
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start; //점수의 총 개수 - 점수보다 크거나 같은 처음 index
    }

    public static void makeQuery(String[] s, int count, String str) {
        if (count == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(s[4]));
            return;
        }

        makeQuery(s, count + 1, str + "-");
        makeQuery(s, count + 1, str + s[count]);
    }
}
