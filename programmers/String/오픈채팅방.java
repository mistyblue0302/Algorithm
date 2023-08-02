import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" "); //Enter uid1234 Muzi
            
            if(s[0].equals("Enter") || s[0].equals("Change")) {
                map.put(s[1], s[2]);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            String type = s[0];
            
            switch(type) {
                case "Enter" :
                    list.add(map.get(s[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave" :
                    list.add(map.get(s[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
