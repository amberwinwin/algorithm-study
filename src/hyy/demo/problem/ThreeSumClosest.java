package hyy.demo.problem;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int sum;
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                int temp = target - sum;
                int left = j + 1;
                int right = nums.length - 1;
                int mid = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (Math.abs(temp - nums[mid]) > 0) {
                        if (temp <= 0) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else if (Math.abs(temp - nums[mid]) == 0) {
                        break;
                    } else {
                        if (temp <= 0) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                int abs = Math.abs(target - sum - nums[mid]);
                if (abs < diff) {
                    diff = abs;
                    res = sum + nums[mid];
                }
            }
        }
        return res;
    }
}
