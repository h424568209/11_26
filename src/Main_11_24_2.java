class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
}
//镜像二叉树
public class Main_11_24_2 {
  public void Mirror(TreeNode root){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left !=null)
            Mirror(root.left);
        if(root.right!= null)
            Mirror(root.right);
  }
}
