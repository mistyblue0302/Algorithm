package DFS;

class 양궁대회 {

    int maxDiff = -1;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, n, ryan, info);
        return answer;
    }

    public void dfs(int depth, int arrows, int[] ryan, int[] appeach) {
        if (arrows == 0) { //화살을 다 쐈다면
            int ryanScore = 0;
            int appeachScore = 0;
            for (int i = 0; i < 11; i++) { //10점부터 0점까지 센다.
                if (ryan[i] == 0 && appeach[i] == 0) {
                    continue;
                }
                if (ryan[i] > appeach[i]) {
                    ryanScore += 10 - i;
                } else {
                    appeachScore += 10 - i;
                }
            }

            if (ryanScore > appeachScore) {
                if (ryanScore - appeachScore == maxDiff) { //방법이 여러가지일 경우
                    for (int i = 10; i >= 0; i--) { //방법이 여러개라면 가장 낮은 점수를 더 많이 맞혀야 하므로 인덱스를 뒤부터 비교
                        if (answer[i] != ryan[i]) { //라이언 배열과 answer 배열의 원소가 다를 경우
                            if (ryan[i] > answer[i]) { //i를 10부터 반복문을 돌았을 때 라이언 배열의 원소가 더 클경우
                                answer = ryan.clone();
                            }
                            return;
                        }
                    }
                }
                if (ryanScore - appeachScore > maxDiff) { //라이언이 우승하는 경우 점수차를 갱신한다.
                    maxDiff = ryanScore - appeachScore;
                    answer = ryan.clone(); //라이언 배열을 갱신한다.
                }
            }
            return;
        }

        if (depth == ryan.length) {
            return;
        }

        for (int i = 0; i <= arrows; i++) {
            ryan[depth] = i;
            dfs(depth + 1, arrows - i, ryan, appeach);
            ryan[depth] = 0;
        }
    }
}


