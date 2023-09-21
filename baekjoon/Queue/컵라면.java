package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 컵라면 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            if (map.containsKey(deadLine)) {
                map.get(deadLine).add(ramen);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ramen);
                map.put(deadLine, list);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list); //1236

        Queue<Integer> queue = new PriorityQueue<>();
        for (int deadline : list) {
            for (int value : map.get(deadline)) {
                queue.add(value);
                while (queue.size() > deadline) {
                    queue.poll();
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        System.out.println(result);
    }
}