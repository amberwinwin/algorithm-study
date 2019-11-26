package hyy.demo.problem;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3 在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length -
 * 1]
 *
 * 示例 1：
 *
 * 输入：[2,1] 输出：false
 *
 * 实例二：
 * [0,1,2,3,4,8,9,10,11,12,11] 输出true
 *
 * 提示：
 *
 * 0 <= A.length <= 10000 0 <= A[i] <= 10000
 *
 * @author hyy
 * @version V2.0, 2019/11/26
 * @copyright
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (null == A || A.length < 3) {
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        while (j - i > 1) {
            if (A[i] < A[i+1] && A[j-1] > A[j]){
                i++;
                j--;
            }else if (A[i] < A[i+1]){
                i++;
            }else if (A[j-1] > A[j]){
                j--;
            }else{
                return false;
            }
        }
        if (j != A.length-1 && i != 0) {
            return true;
        }else{
            return false;
        }
    }
}
