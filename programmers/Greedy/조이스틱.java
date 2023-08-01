class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; //오른쪽으로만 갔을 때
        
        /**
        ex) 'ZYXAAAAAB'인 경우
        현재 내 위치는 'X', index : 2 연속된 'A'가 끝나는 지점은 index : 8에 해당한다.
        [1]   index : 0에서 'X'가 있는 2까지 왔다가 다시 0으로 돌아간 후, 왼쪽으로 더 움직여 B를 바꾸는 경우
            즉, ZYXYZB순으로 움직인 경우
            (i * 2) + (name.length() - 연속된 A가 끝나는 지점)
            여기서 i는 현재 내 위치, 즉 'X'의 index이다.
        [2]  index : 0에서 왼쪽으로 움직였다 다시 0으로 온 후, 오른쪽으로 움직인 경우
            즉, ZBZYX순으로 움직인 경우
            (name.length() - 연속된 A가 끝나는 지점) * 2 + i 
        **/
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - name.charAt(i) + 'A'); //상,하 
            if (i < move && name.charAt(i + 1) == 'A') {
                int endA = i + 1; //A가 끝나는 지점을 endA변수에 구함. 그 지점까지 이동하는데 걸리는 값 왼, 오 비교
                while(endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }
                move = Math.min(move, i * 2 + (name.length() - endA)); //오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2); //왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }
}
