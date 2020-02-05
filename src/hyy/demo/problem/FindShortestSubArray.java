package hyy.demo.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1] 输出: 2 解释: 输入数组的度是2，因为元素1和2的出现频数最大，均为2. 连续子数组里面拥有相同度的有如下所示: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2,
 * 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] 最短连续子数组[2, 2]的长度为2，所以返回2. 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2] 输出: 6 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。 nums[i] 是一个在0到49,999范围内的整数。
 *
 * @author hyy
 * @version V2.0, 2019/12/2
 * @copyright
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int num = map.get(nums[i]);
                map.put(nums[i], num + 1);
                if (num + 1 > max) {
                    max = num + 1;
                }
            } else {
                map.put(nums[i], 1);
                if (1 > max) {
                    max = 1;
                }
            }
        }
        int start = 0;
        int current = 0;
        int shortest = Integer.MAX_VALUE;
        Map<Integer, Integer> record = new HashMap<>();
        while (current < nums.length) {
            if (!record.containsKey(nums[current])) {
                if (1 == max) {
                    return 1;
                } else {
                    record.put(nums[current], 1);
                    current++;
                }
            } else {
                int num = record.get(nums[current]);
                record.put(nums[current], num + 1);
                if (num + 1 == max) {
                    while (start < current) {
                        if (record.get(nums[start]) != null && record.get(nums[start]) == max && shortest > current - start + 1) {
                            shortest = current - start + 1;
                            break;
                        } else {
                            record.put(nums[start], record.get(nums[start] - 1));
                            start++;
                        }
                    }
                }
                current++;
            }
        }
        return shortest == Integer.MAX_VALUE ? nums.length : shortest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
        System.out.println(findShortestSubArray(arr));
    }
}
