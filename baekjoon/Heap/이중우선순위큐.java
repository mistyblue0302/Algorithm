package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //TreeMap은 Key값을 기준으로 정렬된 상태를 유지
            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (str) {
                    case "I":
                        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1); //수를 key로, 횟수를 value
                        break;
                    case "D":
                        if (treeMap.isEmpty()) {
                            break;
                        }
                        if (num == -1) { //최솟값
                            int minKey = treeMap.firstKey();
                            if (treeMap.get(minKey) == 1) { //맵에 해당 값이 있으면 삭제
                                treeMap.remove(minKey);
                            } else { //맵에 해당 값이 없으면
                                treeMap.put(minKey, treeMap.get(minKey) - 1);
                            }
                        } else {
                            int maxKey = treeMap.lastKey();
                            if (treeMap.get(maxKey) == 1) {
                                treeMap.remove(maxKey);
                            } else {
                                treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                            }
                        }
                        break;
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
