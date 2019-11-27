package hyy.demo.problem;

import hyy.demo.base.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 * 示例 1:
 *
 * 输入: root = [  3,
 *              5,     1,
*             6,  2,  0, 8,
 *              7, 4],
 *              p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author hyy
 * @version V2.0, 2019/11/26
 * @copyright
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (null == left && null == right){
            return null;
        }
        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        return right;

    }
}
