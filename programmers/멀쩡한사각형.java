class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 1;

        long a = (long)w; // 가로 길이
        long b = (long)h; // 세로 길이
        answer = (a * b) - (a + b - gcd(a,b));
        return answer;
    }
    public static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}