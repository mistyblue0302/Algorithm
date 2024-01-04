import java.util.*;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) { 
        List<String> list = new ArrayList<>();
        int result = 0;

        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            if(list.contains(s)) {
                result++;
            } else {
                list.add(s.charAt(1) + "" + s.charAt(0));
            }
        }
        return result;
    }
}
