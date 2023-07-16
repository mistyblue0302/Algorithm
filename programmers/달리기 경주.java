import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(String calling : callings) {
            int rank = map.get(calling); //등수 호출
            String before = players[rank -1]; //앞에 있는 선수 호출
            
            players[rank -1] = calling;
            players[rank] = before;
            
            map.put(calling, rank -1);
            map.put(before, rank);
        }
        return players;
    }
}
