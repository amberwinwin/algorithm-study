package hyy.demo.problem;

import java.util.Stack;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100. num1 和num2 都只包含数字 0-9. num1 和num2 都不包含任何前导零。 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * @author hyy
 * @version V2.0, 2020/1/7
 * @copyright
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        for (int i = 0; i < num1.length(); i++) {
            stack1.add(num1.charAt(i) - '0');
        }
        for (int j = 0; j < num2.length(); j++) {
            stack2.add(num2.charAt(j) - '0');
        }
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = stack1.isEmpty() ? 0 : (int) stack1.pop();
            int b = stack2.isEmpty() ? 0 : (int) stack2.pop();
            if (a + b + flag < 10) {
                stack3.add(a + b + flag);
                flag = 0;
            } else {
                stack3.add(a + b + flag - 10);
                flag = 1;
            }
        }
        if (flag == 1) {
            sb.append(flag);
        }
        while (!stack3.isEmpty()) {
            sb.append(stack3.pop());
        }
        return sb.toString();
    }
}
