import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i); 
            
            int firstMax = 0;
            int firstIndex = -1;
            for(int j = 0; j < genres.length; j++) {
                if(str.equals(genres[j]) && firstMax < plays[j]) {
                    firstMax = plays[j]; 
                    firstIndex = j;
                }
            }
            
            // 두 번째 곡이 없을 수도 있음(장르에 속한 곡이 하나라면)
            int secondMax = 0;
            int secondIndex = -1;
            for(int k = 0; k < genres.length; k++) {
                if(str.equals(genres[k]) && secondMax < plays[k] && k != firstIndex) {
                    secondMax = plays[k]; 
                    secondIndex = k; 
                }
            }
            
            answer.add(firstIndex);
            if(secondIndex >= 0) {
                answer.add(secondIndex);
            }
        }
        
        int[] array = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            array[i] = answer.get(i);
        }
        return array;
    }
}
