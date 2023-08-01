class Solution {
    private static String[] personality = {"RT", "CF", "JM", "AN"};
    
    public String solution(String[] survey, int[] choices) {
        int[] array = new int[26];
        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            
            int score = choices[i] - 4;
            if(score == 0) continue;
            if(score > 0) {
                array[b - 'A'] += score;
            } else {
                array[a - 'A'] -= score;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < personality.length; i++) {
            char a = personality[i].charAt(0);
            char b = personality[i].charAt(1);
            
            int countA = array[a - 'A'];
            int countB = array[b - 'A'];
            if(countA == countB) {
                sb.append(a);
            } else if(countA > countB) {
                sb.append(a);
            } else if(countA < countB) {
                sb.append(b);
            }
        }
        
        return sb.toString();
    }
}
