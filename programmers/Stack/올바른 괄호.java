package Stack;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty()) {
                stack.push(c);
            } else if(c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if(c == '(') {
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()) {
            return answer;
        } else {
            answer = false;
            return answer;
        }
    }
}
