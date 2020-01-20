package hyy.demo.problem;

import hyy.demo.base.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * @author hyy
 * @version V2.0, 2020/1/20
 * @copyright
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()){
            size = queue.size();
            double val1 = 0;
            int val2 = size;
            while (size > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null){
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                val1 += tmp.val;
                size --;
            }
            res.add(val1/val2);
        }
        return res;
    }
}
