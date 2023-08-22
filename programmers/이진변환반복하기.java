class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0; //이진 변환 횟수
        int zero = 0; //제거한 0의 개수

        while (!s.equals("1")) {
            int length = s.length(); //12
            s = s.replace("0", ""); //111111
            count++; //이진 변환 횟수
            zero += length - s.length();
            s = Integer.toBinaryString(s.length());
        }

        answer[0] = count;
        answer[1] = zero;
        return answer;
    }
}