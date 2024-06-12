package Simulation;

import java.util.*;
	
class Solution {
    
    static long answer = Long.MIN_VALUE;
    
    public long solution(String expression) {
        String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, 
                         { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
 
        List<String> list = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(expression.substring(start, i)); 
                list.add(expression.charAt(i) + ""); 
                start = i + 1;
            }
        }
        list.add(expression.substring(start)); 
 
        for (int i = 0; i < op.length; i++) {
            List<String> subList = new ArrayList<>(list);
            for (int j = 0; j < op[0].length; j++) {
                for (int k = 0; k < subList.size(); k++) {
                    if (op[i][j].equals(subList.get(k))) {
                        subList.set(k - 1, calc(subList.get(k - 1), subList.get(k), subList.get(k + 1)));
                        subList.remove(k);
                        subList.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(subList.get(0))));
        }
 
        return answer;
    }
 
    public static String calc(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
 
        if (op.equals("+"))
            return n1 + n2 + "";
        else if (op.equals("-"))
            return n1 - n2 + "";
 
        return n1 * n2 + "";
    }
} 
