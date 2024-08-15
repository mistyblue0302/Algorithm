import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> list = new ArrayList<>(map.keySet()); // 장르를 담는 리스트
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1)); // 내림차순
        
        // 장르 별로 가장 많이 재생된 노래
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i); // pop
            int firstMax = 0;
            int firstIndex = -1;
            
            for(int j = 0; j < genres.length; j++) {
                if(str.equals(genres[j]) && firstMax < plays[j]) {
                    firstMax = plays[j];
                    firstIndex = j;
                }
            }
            
            int secondMax = 0;
            int secondIndex = -1;
            for(int k = 0; k < genres.length; k++){
                if(str.equals(genres[k]) && secondMax < plays[k] && k != firstIndex) {
                    secondMax = plays[k];
                    secondIndex = k;
                }
            }
            answer.add(firstIndex);
            
            // 장르에 속한 곡이 하나라면, 하나의 곡만 선택
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
