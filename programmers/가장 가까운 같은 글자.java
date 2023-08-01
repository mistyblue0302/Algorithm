class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] array = s.toCharArray(); 
        answer[0] = -1;
        
        for(int i = 1; i < array.length; i++){
            char c = array[i]; 
            answer[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] == c) {
                    answer[i] = i - j;
                    break;
                }
            }
        }
        
        return answer;
    }
}
