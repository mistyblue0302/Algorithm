class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // String str = s.replace("[^" + a + "]", ""); // a를 제외한 모든 문자를 제거
        // String str = s.replace("[^0-9a-z-_.]", ""); // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for(int i = 0; i < skill_trees.length; i++) { 
            String s = skill_trees[i].replaceAll("[^" + skill + "]", ""); // skill 포함 문자 제외 : BCD, CBD, CB, BD
            for(int j = 0; j < skill.length() + 1; j++) {
                String sub = skill.substring(0, j); // C
                if(s.equals(sub)) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
