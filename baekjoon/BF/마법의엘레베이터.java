package BF;

class 마법의엘레베이터 {
    public int solution(int storey) {
        //숫자가 4이하이면 빼는게 최소이고, 6이상이면 더하는게 최소이다.
        //만약 5라면 앞자리를 보고 결정한다.
        int answer = 0;

        String str = Integer.toString(storey);
        int[] array = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i) - '0';
        }

        for(int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            if(num >= 6) {
                answer += (10 - num);
                if(i == 0) { //가장 높은 자릿수라면 자리 올림이 하나 생기기 때문에
                    answer++; //가장 왼쪽 자릿수에서 자리 올림이 생기면 그것이 10, 100, 1000등의 자리 올림이므로 answer에 1을 더해준다.
                } else {
                    array[i - 1]++; //자리올림
                }
            } else if(num == 5 && i > 0 && array[i - 1] >= 5) { //만약 5라면 앞자리를 보고 결정한다.
                array[i - 1]++;
                answer += 5;
            } else { //4이거나 그 아래일 경우 단순히 그자리만 뺀다.
                answer += num;
            }
        }
        return answer;
    }
}