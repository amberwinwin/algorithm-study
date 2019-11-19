package hyy.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1] 输出: 1
 *
 * @author hyy
 * @version V2.0, 2019/11/19
 * @copyright
 */
public class appreOnlyOneTime {

    /*  1、排序求解 2、借助于set 3、异或 */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1;i<nums.length;i++){
            res = res^nums[i];
        }
        return res;
    }
}
