package hyy.demo.problem;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int count = 1;
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                count ++;
            }else{
                if (count * 4 > len) {
                    return arr[i-1];
                }
                count = 1;
                res = arr[i];
            }
        }
        return res;
    }
}
