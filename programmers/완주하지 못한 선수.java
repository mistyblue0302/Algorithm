import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
         //완주자를 끝까지 비교했는데, 다른 이름이 없다면 참가자의 마지막사람이 미완주자
	    return participant[participant.length-1];
      }  
}
