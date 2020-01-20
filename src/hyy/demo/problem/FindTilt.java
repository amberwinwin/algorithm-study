package hyy.demo.problem;

import hyy.demo.base.TreeNode;

/**
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 *
 * 输入: 1
 *      /   \
 *     2     3
 *     输出: 1
 *     解释: 结点的坡度
 *     2 : 0 结点的坡度
 *     3 : 0 结点的坡度
 *     1 : |2-3| = 1 树的坡度 : 0 + 0 + 1 = 1
 *  注意:
 * 任何子树的结点的和不会超过32位整数的范围。 坡度的值不会超过32位整数的范围。
 *
 * @author hyy
 * @version V2.0, 2020/1/20
 * @copyright
 */
public class FindTilt {
     int res = 0;
    public  int findTilt(TreeNode root) {
        handle(root);
        return res;
    }
    public  int handle(TreeNode root) {
        if (null == root) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int val1 = 0;
        int val2 = 0;
        if (null != left) {
            val1 = handle(left);
        }
        if (null != right) {
            val2 = handle(right);
        }
        res += Math.abs(val1-val2);
        int tmp = val1 + val2 + root.val;
        return tmp;
    }
    public static void main(String[] args) {
    }
}
