class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Long.toString(n, k); //n을 k진수로 변환 : 211020101011
        String[] array = s.split("0");

        for (String data : array) {
            if (data.equals("")) continue;
            Long num = Long.parseLong(data);
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime(Long number) {
        if (number <= 1) return false;
        else if (number == 2) return true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}