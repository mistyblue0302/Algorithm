class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;  // 양쪽 트리의 제일 아래 노드일 때
        if(left == null || right == null) return false;  // 한 쪽만 제일 아래 노드일 때
        
        if(left != null && right != null) {
            if(left.val != right.val) { // 양쪽 값이 서로 다를 때
                return false;
            } 
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
