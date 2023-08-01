import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        
        int indexNumber = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), indexNumber++);
        }
        
        List<Integer> list = new ArrayList<>();
        int N = 27;
        
        for(int i=0; i<msg.length(); i++){
            
            String str = "";
            //현재 인덱스로부터 사전에 등록되어있는 최대한 긴 단어 찾기
            while(i < msg.length() && map.containsKey(str + msg.charAt(i))){
                str += msg.charAt(i);
                i++;
            }
            
            list.add(map.get(str)); //현재 단어의 인덱스 값 저장
            
            if(i < msg.length()){ //마지막 문자까지 도달x, 사전에 없을 때
                map.put(str + msg.charAt(i),N);
                N++;
                i--;
            }
        }
        
        int[] answer = new int[list.size()]; //리스트를 배열로 변환
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
