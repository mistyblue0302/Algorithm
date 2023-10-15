class Solution {

    int answer = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //dfs(3)인 경우 left, right는 null을 가리키게 되고 answer 은 0이 되며, 마지막으로 1이 반환
        //dfs(2)인 경우 left = dfs(4) = 1, right = dfs(5) = 1이 되므로 두 값을 더한 2를 통해 answer가 업데이트. 최종적으로 반환값은 3
        //dfs(1)인 경우 현재 answer2와 왼쪽 서브트리와 오른쪽 서브트리의 깊이를 더한 것이 최대 지름이 된다.
        answer = Math.max(answer, left + right); //현재 노드를 포함하는 최대 경로 길이 계산
        return Math.max(left, right) + 1; //왼쪽 서브트리와 오른쪽 서브트리 중 어느 쪽이 더 깊은지 확인 후 1을 더해 현재 노드를 포함한 경로 길이 반환 -> 현재 노드 기준으로 서브트리의 깊이를 계산하고 재귀로 올라가며 부모 노드까지 깊이 계산
    }
}
