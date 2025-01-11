import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);
        
        for(Integer s : set) {
            if(isPrime(s)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String numbers, String temp, boolean[] visited) {
        if(!temp.equals("")) {
            set.add(Integer.parseInt(temp));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, temp + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
