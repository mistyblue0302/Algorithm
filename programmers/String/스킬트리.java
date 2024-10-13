class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // String s = str.replaceAll("[^" + a +"]", ""); -> a를 제외한 모든 문자 제거하기 위한 정규표현식
        for(String s : skill_trees) {
            String str = s.replaceAll("[^" + skill + "]", "");
            if(skill.startsWith(str)) {
                answer++; 
            }
        }
        
        return answer;
    }
}
