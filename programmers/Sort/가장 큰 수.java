import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] array = new String[numbers.length];
        for(int i = 0; i < array.length; i++){
            array[i] = String.valueOf(numbers[i]);
        }
        //두 수를 번갈아가며 이어붙인 것을 기준으로 내림차순 비교
        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(array[0].equals("0")) {
            return "0"; //만약 입력으로 0,0,0이 들어온다면
        }
        
        for(int i = 0; i < array.length; i++){
            answer += array[i];
        }
        return answer;
    }
}
