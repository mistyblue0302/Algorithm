import java.util.*;

class Solution {
    List<Integer> answer = new ArrayList<>(); //후보키 리스트
    
    public int solution(String[][] relation) {
        
        int rowsize = relation.length; //n개의 데이터
        int colsize = relation[0].length; //m개의 column
        
        for(int i = 1; i < (1<<colsize); i++) { //속성 column의 부분 집합 전부 순회, 0000의 경우는 제외
            Set<String> unique = new HashSet<>();
            for(int j = 0; j < rowsize; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < colsize; k++) {
                    if((i & (1<<k)) > 0) { //& 연산을 이용하여 부분 집합을 선택
                        sb.append(relation[j][k]);
                    }
                }
                unique.add(sb.toString()); //각 튜플의 값을 set으로 옮겨 중복 데이터를 제거
            }
            //유일성 식별
            if(unique.size() != rowsize) { //set의 사이즈랑 행의 개수가 같지 않을 경우 유일성을 만족하지 않는다. (모든 튜플에 대해 유일하게 식별) 
                continue; //다음 반복을 진행
            }
            //유일성을 만족하면 최소성 식별
            checkMin(i);
        }
        return answer.size();
    }
    
    //예로 2(0010)의 경우 6(0110)의 부분 집합이다. 연산을 진행해보면 2 & 6 => 0010 & 0110 => 0010으로 부분 집합인 집합이 결과로 도출된다. -> 최소성 위반
    public void checkMin(int i) { //만약 checkMin(1)이 들어올 경우 리스트에 아무것도 없기 때문에 add, 다음 i가 들어왔을때
        for (Integer key : answer) { //answer의 원소 key는 1
            if((key & i) == key) { //비트연산 하여 부분집합이면 넘어가기
                return;
            } 
        }
        answer.add(i); //부분집합이 아니면 리스트에 추가
    }
}
