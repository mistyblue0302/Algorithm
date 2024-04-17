class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return array(0, nums.length - 1, nums);
    }

    public TreeNode array(int start, int end, int[] nums) {
        if(start > end) return null;  // 배열을 계속 반으로 나누다 보면 음수가 될 수 있다.
        
        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = array(start, mid - 1, nums);
        node.right = array(mid + 1, end, nums);
        return node;
    }
}
