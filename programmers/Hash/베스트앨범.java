import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1)); // 내림차순
        
        for(int i = 0; i < list.size(); i++) {
            String genre = list.get(i); 
            
            int firstMax = 0;
            int firstIndex = -1;
            for(int j = 0; j < genres.length; j++) {
                if(genre.equals(genres[j]) && firstMax < plays[j]) {
                    firstMax = plays[j]; 
                    firstIndex = j;
                }
            }
            
            int secondMax = 0;
            int secondIndex = -1;
            for(int k = 0; k < genres.length; k++) {
                if(genre.equals(genres[k]) && secondMax < plays[k] && k != firstIndex) {
                    secondMax = plays[k]; 
                    secondIndex = k; 
                }
            }
            
            answer.add(firstIndex);
            if(secondIndex >= 0) answer.add(secondIndex);
        }
        
        int[] array = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            array[i] = answer.get(i);
        }
        return array;
    }
}
