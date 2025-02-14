import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        // 많이 재생된 장르 -> 장르 내에서 많이 재생된 순으로 정렬
        // 장르 내에서 재생 횟수가 같다면 고유 번호가 낮은 노래 먼저 -> 오름차순
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i]; 
            int play = plays[i]; 
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o2) - map.get(o1))); // 내림차순
        
        for(int i = 0; i < list.size(); i++) {
            String genre = list.get(i); 
            
            int firstIndex = -1; 
            int firstMax = 0; 
            for(int j = 0; j < genres.length; j++) {
                if(genre.equals(genres[j]) && firstMax < plays[j]) {
                    firstMax = plays[j];
                    firstIndex = j; 
                }
            }
            
            int secondIndex = -1;
            int secondMax = 0; 
            for(int k = 0; k < genres.length; k++) {
                if(genre.equals(genres[k]) && k != firstIndex && secondMax < plays[k]) {
                    secondMax = plays[k];
                    secondIndex = k;
                }
            }
            
            answer.add(firstIndex);
            // 장르에 속한 곡이 하나라면 -> 하나의 곡만 선택(초기 인덱스를 -1로 두고 판별)
            if(secondIndex >= 0) {
                answer.add(secondIndex);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}
