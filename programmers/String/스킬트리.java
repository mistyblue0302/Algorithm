package String;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees) {
            String temp = s; //BACDE
            for(int i = 0; i < s.length(); i++) {
                String t = String.valueOf(s.charAt(i)); //B
                if(!skill.contains(t)) {
                    temp = temp.replace(t, "");
                }
            }

            if(skill.indexOf(temp) == 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
