package DFS;

import java.util.*;

class 소수찾기 {

    boolean[] visited = new boolean[7];
    List<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, i + 1, "");
        }

        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(String numbers, int length, String s) {
        if (s.length() == length) {
            int num = Integer.parseInt(s);
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                s += numbers.charAt(i);
                dfs(numbers, length, s);
                visited[i] = false;
                s = s.substring(0, s.length() - 1);
            }
        }
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
