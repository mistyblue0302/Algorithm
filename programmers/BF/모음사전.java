class Solution {
    public int solution(String word) {
        //I가 1536번째이므로 E는 781번째
        //5번째 자리의 모음이 변경될 때는 +1, 4번째 자리의 모음이 변경될 때는 +6, 1번째 자리의 모음이 변경될 때는 +781
        int answer = word.length();
        
        String s = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        
        for(int i=0; i < word.length(); i++){
            int index = s.indexOf(word.charAt(i));
            answer += x[i] * index;
        }
        return answer;
    }
}
