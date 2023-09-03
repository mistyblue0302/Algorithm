package Stack;

import java.util.*;

class 짝지어제거하기 {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
