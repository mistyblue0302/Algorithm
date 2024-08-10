class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        //String str = s.replace("[^a]", "b"); // a를 제외한 문자를 b로 치환
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
