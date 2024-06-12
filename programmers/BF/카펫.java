class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow; 
        for(int i = 1; i <= sum; i++) { // 가로
            if(sum % i == 0) { 
                int height = sum / i; // 세로
                if((i - 2) * (height - 2) == yellow) {
                    answer[0] = i;
                    answer[1] = height;
                }
            }
        }
        return answer;
    }
}
