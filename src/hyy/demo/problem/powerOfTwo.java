package hyy.demo.problem;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1 输出: true 解释: 20 = 1
 *
 * @author hyy
 * @version V2.0, 2019/11/20
 * @copyright
 */
public class powerOfTwo {
    /* 另外的思路是按位与 */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

}
