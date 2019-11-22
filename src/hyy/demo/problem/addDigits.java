package hyy.demo.problem;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38 输出: 2 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * @author hyy
 * @version V2.0, 2019/11/20
 * @copyright
 */
public class addDigits {

    /*    public int addDigits(int num) {
            int sum = 0;
            while (num > 0){
                sum += num%10;
                num /= 10;
                if (num  == 0){
                    if (sum < 10){
                        return sum;
                    }
                    num = sum;
                    sum = 0;
                }
            }
            return sum;
        }*/

    /**
     * 把整数拆解成多项式去理解，剩余不能被9取模的数就是我们要的数
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10){
            return num;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
