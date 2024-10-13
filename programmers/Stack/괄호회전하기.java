package Stack;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i, s.length()) + s.substring(0, i);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '(' && c == ')') { // 올바른 괄호라면 삭제하기 위해 -> 그러면 올바른 괄호로만 구성될 경우 스택의 사이즈는 0
                    stack.pop();
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            
            if(stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
