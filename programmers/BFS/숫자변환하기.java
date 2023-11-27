package BFS;

import java.util.*;

class 숫자변환하기 {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        //boolean[] visited = new boolean[1000001]; 배열을 사용할 경우 배열의 크기가 크면 메모리 초과
        //y가 x보다 항상 크거나 같기 때문에
        queue.add(x);
        set.add(x);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int num = queue.poll();
                if(num == y) {
                    return answer;
                }

                if(!set.contains(num + n) && num + n <= y) {
                    set.add(num + n);
                    queue.add(num + n);
                }

                if(!set.contains(num * 2) && num * 2 <= y) {
                    set.add(num * 2);
                    queue.add(num * 2);
                }

                if(!set.contains(num * 3) && num * 3 <= y) {
                    set.add(num * 3);
                    queue.add(num * 3);
                }
            }
            answer++;
        }

        return -1;
    }
}
