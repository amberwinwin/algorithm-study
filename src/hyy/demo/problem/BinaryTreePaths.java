package hyy.demo.problem;

import hyy.demo.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 *
 * @author hyy
 * @version V2.0, 2020/1/21
 * @copyright
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) {
            return res;
        }
        handle(root,root.val + "");
        return res;
    }
    public void handle(TreeNode root,String str) {
        if (null == root) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(str);
            return;
        }
        str += "->";
        String left = str;
        String right = str;
        if (null != root.left) {
            handle(root.left,left + root.left.val);
        }
        if (null != root.right) {
            handle(root.right,right + root.right.val);
        }
    }
}
