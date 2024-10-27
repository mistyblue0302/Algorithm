import java.util.*;

class Solution {
    Map<String, String> map = new HashMap<>();
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        map.put("B#", "b"); 
        map.put("C#", "c"); 
        map.put("D#", "d"); 
        map.put("F#", "f");
        map.put("G#", "g"); 
        map.put("A#", "a");
        m = change(m);
        
        int maxTime = 0; 
        for(int i = 0; i < musicinfos.length; i++) {
            String[] s = musicinfos[i].split(",");
            int time = getTime(s[0], s[1]); 
            String title = s[2]; 
            String melody = change(s[3]); 
            
            while(melody.length() < time) {
                melody += melody; 
            }
            
            melody = melody.substring(0, time); 
            
            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
            if(melody.contains(m)) { 
                if(maxTime < time) {
                    maxTime = time;
                    answer = title;
                }
            }
        }
        return answer;
    }
    
    public int getTime(String s1, String s2) { 
        String[] str1 = s1.split(":");
        String[] str2 = s2.split(":"); 
        
        int hour1 = Integer.parseInt(str1[0]) * 60;
        int hour2 = Integer.parseInt(str2[0]) * 60;
        
        int minute1 = Integer.parseInt(str1[1]);
        int minute2 = Integer.parseInt(str2[1]);
        
        return (hour2 + minute2) - (hour1 + minute1);
    }
    
    public String change(String s) { 
        for(String key : map.keySet()) {
            s = s.replace(key, map.get(key));
        }
        return s;
    }
}
