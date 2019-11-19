package hyy.demo;

import hyy.demo.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 *
 *  3
 * / \
 * 9  20
 *   /  \
 *  15   7
 *
 * 返回其层次遍历结果：
 *
 * [ [3], [9,20], [15,7] ]
 *
 * @author hyy
 * @version V2.0, 2019/11/19
 * @copyright
 */
public class levelTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size  = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null){
                    queue.add(tmp.left);
                }
                if (tmp.right != null){
                    queue.add(tmp.right);
                }
                size--;
            }
            res.add(list);
            if (!queue.isEmpty()){
                size = queue.size();
            }
        }
        return res;
    }

}

