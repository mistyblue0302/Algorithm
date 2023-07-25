import java.util.*;

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] visit = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;
        for(int i = 0; i < numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        
        for(int i = 0; i < arr.size(); i++){
            if(prime(arr.get(i))) answer++;              
        }
        
        return answer;
    }
	
	public static void dfs(String str, String temp, int m) {
        if(temp.length() == m){
            int num = Integer.parseInt(temp);
            if(!arr.contains(num)){
                arr.add(num);
            }
        }
        
        for(int i = 0; i < str.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, m);
                visit[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
	}
	
	public static boolean prime(int n) {
		if(n < 2) return false;
		
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}
