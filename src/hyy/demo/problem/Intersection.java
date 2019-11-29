package hyy.demo.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2] 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4] 说明:
 *
 * 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 *
 * @author hyy
 * @version V2.0, 2019/11/29
 * @copyright
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] nums = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int pos = 0;
        while (it.hasNext()) {
            nums[pos++] = it.next();
        }
        return nums;
    }
}
