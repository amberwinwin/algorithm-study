package hyy.demo.problem;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0] 输出：null 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4] 示例 2：
 *
 * 输入：[1,2,3] 输出：null 解释：调用函数后，输入的数组将被修改为：[1,2,3]  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000 0 <= arr[i] <= 9
 *
 * @author hyy
 * @version V2.0, 2019/11/29
 * @copyright
 */
public class DuplicateZeros {

    /**
     * 偏移量  时间复杂度O(n)
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return;
        }
        int offset = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                offset++;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                if (i + offset < len) {
                    arr[i + offset] = arr[i];
                }
            } else {
                offset--;
                if (i + offset < len) {
                    arr[i + offset] = 0;
                }
                if (i + offset + 1 < len) {
                    arr[i + 1 + offset] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums);
        for (int ele : nums) {
            System.out.print(ele + ",");
        }
    }
}
