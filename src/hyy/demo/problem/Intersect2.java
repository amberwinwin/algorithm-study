package hyy.demo.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9] 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。
 *
 * @author hyy
 * @version V2.0, 2019/12/31
 * @copyright
 */
public class Intersect2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2 || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int len1 = nums1.length - 1;
        int len2 = nums2.length - 1;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i <= len1 && j <= len2) {
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] nums = new int[list.size()];
        if (list.size() > 0){
            for (int k = 0;k<list.size();k++){
                nums[k] = list.get(k);
            }
        }
        return nums;
    }
}
