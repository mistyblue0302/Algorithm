import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        // 체육복을 도난당한 학생을 Set에 저장 -> 체육복 x
        for(int l : lost) {
            lostSet.add(l);
        }
        
        // 여벌이 있는데 도난당했으면 -> 빌려줄 수 없음
        // 여벌이 있는데 도난당하지 않았으면 -> 빌려줄 수 있음
        for(int r : reserve) {
            if(lostSet.contains(r)) {
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        
        }
        
        // 체육복 빌려주기
        for(int r : reserveSet) {
            if(lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if(lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }
        return n - lostSet.size();
    }
}
