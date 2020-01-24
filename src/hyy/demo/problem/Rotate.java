package hyy.demo.problem;


/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
//旋转数组 ？？
public class Rotate {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length <= 1) {
            return;
        }
        int pre = nums[nums.length - k];
        int count = nums.length;
        int i = 0;
        while (count > 0) {
            int temp = nums[i];
            nums[i] = pre;
            pre = temp;
            i = (i + k) % nums.length;
            count--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums, 3);
        for (int ele : nums) {
            System.out.println(ele);
        }
    }
}
