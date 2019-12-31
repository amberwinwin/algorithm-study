package hyy.demo.problem;

import java.util.Stack;

/**
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 *
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2 输出："110" 解释：(-2) ^ 2 + (-2) ^ 1 = 2 示例 2：
 *
 * 输入：3 输出："111" 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3 示例 3：
 *
 * 输入：4 输出："100" 解释：(-2) ^ 2 = 4  
 *
 * 提示：
 *
 * 0 <= N <= 10^9
 *
 * @author hyy
 * @version V2.0, 2019/12/31
 * @copyright
 */
public class BaseNeg2 {

    public static String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        // 记录二进制每个位上的值
        int[] bits = new int[32];
        int pos = 0;
        while (N > 0) {
            bits[pos++] = N % 2;
            N /= 2;
        }
        pos = 0;
        // 记录负二进制每个位上的值
        Stack<Integer> stack = new Stack<>();
        while (pos < 32) {
            if (bits[pos] > 1) {
                bits[pos] = 0;
                bits[pos + 1] += 1;
            }
            if (pos % 2 == 0) {
                stack.add(bits[pos]);
            } else {
                // 遇到不为0的需要前面偶位数帮忙抵消
                if (bits[pos] != 0) {
                    if (pos + 1 < 32) {
                        bits[pos + 1] += 1;
                        if (bits[pos + 1] > 1) {
                            bits[pos + 1] = 0;
                            if (pos + 2 < 32) {
                                bits[pos + 2] += 1;
                            }
                        }
                    }
                }
                stack.add(bits[pos]);
            }
            pos++;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (flag) {
                sb.append(stack.pop());
            } else {
                if (stack.pop() == 1) {
                    sb.append(1);
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(baseNeg2(14));
    }
}
