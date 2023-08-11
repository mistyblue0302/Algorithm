package DFS;

import java.util.ArrayList;

public class 수식최대화 {

    char[] operand = {'+', '-', '*'};
    boolean[] visited = new boolean[3];
    ArrayList<Long> numbers = new ArrayList<>();
    ArrayList<Character> operands = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {

        String num = "";
        for (int i = 0; i < expression.length(); i++) {

            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                numbers.add(Long.parseLong(num));
                operands.add(expression.charAt(i));
                num = "";
            }
        }
        numbers.add(Long.parseLong(num));

        dfs(0, new char[3]);
        return answer;
    }

    public void dfs(int count, char[] p) {
        if (count == 3) {
            ArrayList<Long> copyNumbers = new ArrayList<>(numbers);
            ArrayList<Character> copyOperands = new ArrayList<>(operands);

            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < copyOperands.size(); j++) {
                    if (copyOperands.get(j) == p[i]) {
                        Long temp = calc(copyNumbers.remove(j), copyNumbers.remove(j), p[i]);
                        copyNumbers.add(j, temp);
                        copyOperands.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyNumbers.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[count] = operand[i];
                dfs(count + 1, p);
                visited[i] = false;
            }
        }

    }

    public Long calc(Long num1, Long num2, char oper) {
        long num = 0;
        if (oper == '*') {
            return num1 * num2;
        } else if (oper == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}

