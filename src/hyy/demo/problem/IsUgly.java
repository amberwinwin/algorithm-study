package hyy.demo.problem;

/**
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6 输出: true 解释: 6 = 2 × 3
 *
 * 说明：
 *
 * 1 是丑数。 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 *
 * @author hyy
 * @version V2.0, 2019/11/26
 * @copyright
 */
public class IsUgly {

    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
