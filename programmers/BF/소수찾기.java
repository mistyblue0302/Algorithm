import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, "", visited);
        
        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String numbers, String current, boolean[] visited) {
        if(!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {
        if(number < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {  
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
