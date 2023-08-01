import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //keySet를 리스트에 넣기
        List<String> list = new ArrayList<>(map.keySet());
        //keySet를 value 기준으로 내림차순
        Collections.sort(list, (o1,o2) -> map.get(o2) - map.get(o1));
        
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i); //pop
            int firstMax = 0;
            int firstIdx = -1;
            //첫 번째로 많이 재생된 노래 찾기
            for(int j = 0; j < genres.length; j++){
                if(genres[j].equals(s) && firstMax < plays[j]) {
                    firstMax = plays[j]; //2500
                    firstIdx = j; //4
                }
            }
            int secondMax = 0;
            int secondIdx = -1;
            //두 번째로 많이 재생된 노래 찾기
            for(int k = 0; k < genres.length; k++){
                if(genres[k].equals(s) && secondMax < plays[k] && k != firstIdx) {
                    secondMax = plays[k]; //600
                    secondIdx = k; //1
                }
            }
            answer.add(firstIdx);
            if(secondIdx >= 0) { //두 번째로 재생된 노래가 있다면 리스트에 저장
                answer.add(secondIdx);
            }
        }
        
        int[] array = new int[ answer.size()];
        for(int i = 0; i < answer.size(); i++){
            array[i] = answer.get(i);
        }
        return array;
    }
}
