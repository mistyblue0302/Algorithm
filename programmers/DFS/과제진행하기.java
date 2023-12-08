package DFS;

import java.util.*;

class 과제진행하기 {

    public String[] solution(String[][] plansArr) {
        Plan[] plans = new Plan[plansArr.length];
        for (int i = 0; i < plansArr.length; i++) {
            plans[i] = new Plan(plansArr[i]);
        }
        Arrays.sort(plans, (a, b) -> a.start - b.start);

        Stack<Plan> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < plans.length - 1; i++) {
            Plan current = plans[i];
            Plan next = plans[i + 1];

            if (current.getEndTime() > next.start) {
                current.playtime = current.getEndTime() - next.start;
                stack.push(current);
                continue;
            }
            answer.add(current.name);

            int restTime = next.start - current.getEndTime();

            while (!stack.isEmpty()) {
                Plan p = stack.peek();
                int diff = p.playtime - restTime;
                p.playtime = diff;
                restTime = diff * -1;
                if (diff > 0) {
                    break;
                }
                answer.add(stack.pop().name);
            }
        }

        answer.add(plans[plans.length - 1].name); //마지막 index의 plan 처리
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name); // stack에 남아있던 plan들 넣기
        }
        return answer.toArray(new String[answer.size()]);
    }
}

class Plan {

    String name;
    int start;
    int playtime;

    public Plan(String name, String start, String playtime) {
        this.name = name;
        String[] time = start.split(":");
        this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 시간 * 60 + 분
        this.playtime = Integer.parseInt(playtime);
    }

    public Plan(String[] plan) {
        this(plan[0], plan[1], plan[2]);
    }

    public int getEndTime() {
        return start + playtime;
    }
}
