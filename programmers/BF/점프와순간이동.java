package BF;

public class 점프와순간이동 {
    public int solution(int n) {
        int result = 0;
        //순간이동을 많이 쓰고 점프를 적게 쓰자
        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                result++;
            }
        }
        return result;
    }
}