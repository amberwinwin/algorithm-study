package hyy.demo.problem;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i<j){
            boolean x = handle(arr[i]);
            boolean y = handle(arr[j]);
            if (x && y){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                continue;
            }
            if (!x){
                i++;
                continue;
            }
            if (!y) {
                j--;
                continue;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char ele : arr) {
            res.append(ele);
        }
        return res.toString();
    }

    public boolean handle(Character x) {
        if (x == 'a' || x == 'e' ||
                x == 'i' || x == 'o' || x == 'u' ||
                x == 'A' || x == 'E' ||
                x == 'I' || x == 'O' || x == 'U') {
            return true;
        }
        return false;
    }
}
