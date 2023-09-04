import java.util.*;

class 모의고사 {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] count = {0,0,0};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) count[0]++;
            if(answers[i] == second[i % 8]) count[1]++;
            if(answers[i] == third[i % 10]) count[2]++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count.length; i++) {
            if(max == count[i]) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}