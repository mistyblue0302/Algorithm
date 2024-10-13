import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>(); // 94
        
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택은 후입선출 구조인데, for-each 구문으로 조회할 경우 리스트처럼 순차적으로 접근 가능
        // 스택이 내부적으로 벡터를 상속하기 때문에 가능
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
