class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isCheck(root.left, root.right);
    }

    public boolean isCheck(TreeNode left, TreeNode right) {
        
        if(left.val != right.val) { // 양쪽 값이 서로 다를 때
            return false;
        }

        if(left == null && right == null) { // 양쪽 트리의 제일 아래 노드일 때
            return true;
        }

        if(left == null || right == null) { // 한 쪽만 제일 아래 노드일 때
            return false;
        }

        return isCheck(left.left, right.right) && isCheck(left.right, right.left);
    }
}
