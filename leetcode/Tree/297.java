public class Codec {
    String X = "X"; //null값을 X 문자열로 나타낸다.

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
         //처음 serialize 메소드가 호출되면 가장 먼저 루트 노드에 대한 root.val 값인 1을 직렬화 하고
        //left 변수에 serialize(root.left)가 할당 -> 왼쪽 서브 트리에 대한 직렬화 수행 2를 반환, 직렬화가 완료되면
        //right 변수에 serialize(root.right)가 할당 -> 오른쪽 서브 트리를 직렬화 하기 위한 재귀 호출 -> 1,2,3
        return root.val + "," + left + "," + right;
    }

    //Decodes your encoded data to tree.
    String[] array;
    int index = 0;

    //1,2,3,X,X,4,5 -> 1,2,X,X,3,4,5,X,X,X,X
    public TreeNode deserialize(String data) {
        array = data.split(",");
        return dfs();
    }

    private TreeNode dfs() {
        if (array[index].equals(X)) {
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(array[index++]));
        root.left = dfs();
        root.right = dfs();
        return root;
    }
}
