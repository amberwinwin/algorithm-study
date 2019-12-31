package hyy.demo.problem;

import hyy.demo.base.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值 结点右子树中所含结点的值大于等于当前结点的值 左子树和右子树都是二叉搜索树 例如： 给定 BST [1,null,2,2],
 *
 * 1 \ 2 / 2 返回[2].
 *
 * @author hyy
 * @version V2.0, 2019/12/30
 * @copyright
 */
public class FindMode {

    List<Integer> list = new ArrayList<>();
    int pre = 0;
    int max = 0;
    int currentTimes = 0;
    public int[] findMode(TreeNode root) {
        handle(root);
        int[] nums = new int[list.size()];
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
        }
        return nums;
    }

    public void handle(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        handle(left);
        if (max == 0){
            pre = root.val;
            currentTimes = 1;
        }else{
            if (root.val == pre){
                currentTimes ++;
            }else{
                pre = root.val;
                currentTimes = 1;
            }
        }
        if (currentTimes > max){
            max = currentTimes;
            list.clear();
            list.add(root.val);
        }else if (currentTimes == max){
            list.add(root.val);
        }
        handle(right);
    }
}
