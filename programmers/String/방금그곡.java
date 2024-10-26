import java.util.*;

class Solution {
    public static HashMap<String, String> map = new HashMap<>();
    
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
        for(int i = 0; i < musicinfos.length; i++){
            String[] str = musicinfos[i].split(",");
            int time = getTime(str[0], str[1]); 
            String melody = change(str[3]); 
            
            while(melody.length() < time) {
                melody += melody;
            }
            
            melody = melody.substring(0, time);
            if(melody.contains(m)) {
                if(maxTime < time) {
                    maxTime = time;
                    answer = str[2];
                }
            }
        }
        
        return answer;
    }
    
    public static int getTime(String s1, String s2) {
        String[] str1 = s1.split(":"); 
        String[] str2 = s2.split(":");
        
        int hour1 = Integer.parseInt(str1[0]) * 60; 
        int hour2 = Integer.parseInt(str2[0]) * 60; 
        
        int minute1 = Integer.parseInt(str1[1]);
        int minute2 = Integer.parseInt(str2[1]);
        
        return (hour2 + minute2) - (hour1 + minute1);
    }
    
    public static String change(String str) {
        for(String key : map.keySet()) {
            str = str.replace(key, map.get(key));
        }
        return str;
    }
}
