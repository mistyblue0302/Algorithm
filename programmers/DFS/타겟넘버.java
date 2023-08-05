package DFS;

class 타겟넘버 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int index, int sum) {

        if(index == numbers.length) {
            if(target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, target, index + 1, sum + numbers[index]);
            dfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }
}
