package hyy.demo.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3] 输出：[[1,2],[2,3],[3,4]]
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5 -10^6 <= arr[i] <= 10^6
 *
 * @author hyy
 * @version V2.0, 2019/11/22
 * @copyright
 */
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int[] table = new int[arr.length];
        Arrays.sort(arr);
        int min = arr[arr.length - 1] - arr[0];
        for (int i = arr.length - 1; i > 0; i--) {
            table[i] = arr[i] - arr[i - 1];
            if (table[i] < min) {
                min = table[i];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < table.length; i++) {
            if (table[i] == min){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i-1]);
                tmp.add(arr[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
