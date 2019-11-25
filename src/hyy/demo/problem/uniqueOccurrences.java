package hyy.demo.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3] 输出：true 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000 -1000 <= arr[i] <= 1000
 *
 * [-12,2,21,-11,8,-14,16,-12,4,19,17,-17,-14,-9,20,21,12,-12,15,-14,11,18]
 *
 * @author hyy
 * @version V2.0, 2019/11/22
 * @copyright
 */
public class uniqueOccurrences {

    public static boolean uniqueOccurrences2(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);
        int count = 1;
        int[] table = new int[1001];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (i == arr.length-1){
                    if (table[count] > 0){
                        return false;
                    }
                }
            } else {
                if (table[count] > 0){
                    return false;
                }
                table[count] = 1;
                if (i == arr.length-1){
                    if (table[1] > 0){
                        return false;
                    }
                }else{
                    count = 1;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] arr = new int[]{-12,2,21,-11,8,-14,16,-12,4,19,17,-17,-14,-9,20,21,12,-12,15,-14,11,18};
        Arrays.sort(arr);
        for (int ele : arr){
            System.out.print(ele+",");
        }
        System.out.println(uniqueOccurrences2(arr));
    }
}
