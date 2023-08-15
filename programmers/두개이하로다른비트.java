class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) { //짝수의 경우 + 1
                answer[i] = numbers[i] + 1;
            } else { //홀수의 경우
                String s = Long.toString(numbers[i], 2); //Long형을 2진수의 String으로 반환
                int index = s.lastIndexOf("0");
                if (index != -1) { //0이 있는 경우
                    s = s.substring(0, index) + "10" + s.substring(index + 2, s.length());
                    answer[i] = Long.parseLong(s, 2);
                } else { //0이 없는 경우
                    s = "10" + s.substring(0, s.length() - 1);
                    answer[i] = Long.parseLong(s, 2); //2진수를 10진수로
                }
            }
        }
        return answer;
    }
}
