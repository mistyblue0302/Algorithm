class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
    
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    public void dfs(int index, int[] numbers, int target, int current) {
        if(index == numbers.length) { // 끝까지 연산을 다 수행했을 때
            if(current == target) {
                answer++;
            }
        } else {
            dfs(index + 1, numbers, target, current + numbers[index]);
            dfs(index + 1, numbers, target, current - numbers[index]);
        }
    }
}
