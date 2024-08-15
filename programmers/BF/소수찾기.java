import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(0, "", numbers, visited);
        
        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int depth, String s, String numbers, boolean[] visited) {
        if(!s.equals("")) {
            set.add(Integer.parseInt(s));
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, s + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
