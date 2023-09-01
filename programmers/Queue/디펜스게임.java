package Queue;

import java.util.*;

class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //높은 것부터 우선순위
        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]);
            n -= enemy[i];
            if (n < 0) {
                if (k == 0) {
                    return queue.size() - 1;
                } else {
                    k--;
                    n += queue.poll(); //가장 큰 수에 대해서 무적권을 사용
                    queue.add(0);
                }
            }
        }
        return queue.size();
    }
}
