package hyy.demo.problem;

import hyy.demo.base.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3] 1 \ 2 / 3
 *
 * 输出: [1,3,2]
 *
 * @author hyy
 * @version V2.0, 2020/1/1
 * @copyright
 */
public class InorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 记录访问过左子树的节点 则不再访问
        Stack<TreeNode> nodes = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (nodes.isEmpty() || tmp != nodes.peek()) {
                nodes.add(tmp);
                while (tmp.left != null) {
                    stack.add(tmp.left);
                    tmp = tmp.left;
                    nodes.add(tmp);
                }
            } else {
                if (!nodes.isEmpty()) {
                    nodes.pop();
                }
                stack.pop();
                list.add(tmp.val);
                if (null != tmp.right) {
                    stack.add(tmp.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){

    }
}
