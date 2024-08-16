class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
       
        int sum = brown + yellow;
        for(int width = 1; width <= sum; width++) { // 가로의 길이
            if(sum % width == 0) {
                int height = sum / width; // 세로의 길이
                if((width - 2) * (height - 2) == yellow) {
                    answer[0] = height;
                    answer[1] = width;
                    return answer;
                }       
            }
        }
        
        return answer;
    }
}
