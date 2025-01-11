class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow; // 전체 타일 수
        for(int width = 1; width <= sum; width++) { // 가로길이
            if(sum % width == 0) { // 세로길이
                int height = sum / width; 
                
                if((width - 2) * (height - 2) == yellow) {
                    answer[0] = Math.max(width, height);
                    answer[1] = Math.min(width, height);
                }
            }
        }
        return answer;
    }
}
