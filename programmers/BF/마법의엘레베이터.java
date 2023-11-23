package BF;

class 마법의엘레베이터 {
    public int solution(int storey) { //민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수
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
                if(i == 0) {
                    answer++;
                } else {
                    array[i - 1]++;
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