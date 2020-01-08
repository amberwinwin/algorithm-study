package hyy.demo.problem;

import hyy.demo.base.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 * 0 / \ -3   9 /   / -10  5
 *
 * @author hyy
 * @version V2.0, 2020/1/7
 * @copyright
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        return handle(nums, 0, nums.length - 1);
    }

    public TreeNode handle(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            right--;
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = handle(nums, left, mid - 1);
        node.right = handle(nums, mid + 1, right);
        return node;
    }
}
