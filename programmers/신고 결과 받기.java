import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { //정지 처리 결과 메일을 받은 횟수를 리턴
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            String name = id_list[i];
            map.put(name, new HashSet<>());
            map2.put(name, i);
        }
        
        for(String s : report) {
            String[] str = s.split(" ");
            String from = str[0]; //신고한 사람
            String to = str[1]; //신고 받은 사람
            map.get(to).add(from); //신고 받은 사람에 대해 누가 신고했는지
        }
        
        for(int i = 0; i < id_list.length; i++){
            HashSet<String> set = map.get(id_list[i]);
            if(set.size() >= k) {
                for(String s : set) {
                    answer[map2.get(s)]++;
                }
            }
        }
        return answer;
    }
}
