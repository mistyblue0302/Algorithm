import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        // 여벌 체육복과 도난당한 학생을 Set에 저장
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                // 여벌이 있지만 도난당한 학생이면 자기 체육복 사용
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }

        // 체육복 빌려주기
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1); // 앞번호 학생에게 빌려줌
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1); // 뒷번호 학생에게 빌려줌
            }
        }

        return n - lostSet.size(); // 전체 학생 수 - 체육복 없는 학생 수
    }
}
