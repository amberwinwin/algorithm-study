package hyy.demo.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1] 输出: 2 解释: 输入数组的度是2，因为元素1和2的出现频数最大，均为2. 连续子数组里面拥有相同度的有如下所示: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2,
 * 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] 最短连续子数组[2, 2]的长度为2，所以返回2. 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2] 输出: 6 注意:
 *
 * nums.length 在1到50,000区间范围内。 nums[i] 是一个在0到49,999范围内的整数。
 *
 * @author hyy
 * @version V2.0, 2019/12/2
 * @copyright
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] table = new int[50000];
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            table[nums[i]] += 1;
            if (table[nums[i]] > degree) {
                degree = table[nums[i]];
            }
        }
        if (degree == 1) {
            return 1;
        }
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }
        int start = 0;//记录该数组起始位置
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (table[nums[i]] != 0) {
                table[nums[i]] += 1;
                if (table[nums[i]] >= degree) {
                    if (nums[i] != nums[start]){
                        if (minLen > i-start){
                            minLen = i-start;
                        }
                    }else{
                        if (minLen > i - start + 1) {
                            minLen = i - start + 1;
                        }
                    }
                    table[nums[start]] -= 1;
                    start++;
                }
            }else{
                table[nums[i]] += 1;
            }
        }
        if (minLen == Integer.MAX_VALUE){
            return nums.length;
        }else{
            return minLen;
        }
    }
}
