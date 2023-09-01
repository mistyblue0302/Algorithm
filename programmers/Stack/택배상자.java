package Stack;

import java.util.*;

class 택배상자 {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }

        int answer = 0;
        int index = 0;
        while (true) {
            boolean flag = false;
            if (!queue.isEmpty() && queue.peek() == order[index]) {
                queue.poll();
                answer++;
                index++;
                flag = true;
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
                flag = true;
                continue;
            }

            if (!queue.isEmpty() && queue.peek() != order[index]) {
                stack.push(queue.poll());
                flag = true;
            }

            if (!flag) {
                break;
            }
        }

        return answer;
    }
}
