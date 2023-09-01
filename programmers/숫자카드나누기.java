import java.util.*;

class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        //각 배열의 최대 공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]); //10
            gcdB = gcd(gcdB, arrayB[i]); //1
        }

        //서로의 배열을 나눌수 없는지 확인
        if (notDivisible(arrayA, gcdB)) {
            if (answer < gcdB) {
                answer = gcdB;
            }
        }

        if (notDivisible(arrayB, gcdA)) {
            if (answer < gcdA) {
                answer = gcdA;
            }
        }
        return answer;
    }

    public int gcd(int a, int b) { //최대공약수
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public boolean notDivisible(int[] array, int num) {
        for (int n : array) {
            if (n % num == 0) { //모든 숫자가 조건을 만족해야 false반환
                return false;
            }
        }
        return true;
    }
}