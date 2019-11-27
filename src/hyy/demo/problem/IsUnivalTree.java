package hyy.demo.problem;

import hyy.demo.base.TreeNode;

/**
 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。

 输入：[1,1,1,1,1,null,1]
 输出：true
 * @author hyy
 * @version V2.0, 2019/11/27
 * @copyright
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (null != left){
            if (left.val != root.val){
                return false;
            }
        }
        if (null != right){
            if (right.val != root.val){
                return false;
            }
        }
        return isUnivalTree(left) && isUnivalTree(right);
    }
}
