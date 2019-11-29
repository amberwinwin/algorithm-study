package hyy.demo.problem;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba" 输出: True 示例 2:
 *
 * 输入: "abca" 输出: True 解释: 你可以删除c字符。 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author hyy
 * @version V2.0, 2019/11/29
 * @copyright
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (help(s)) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)){
                if (help(s.substring(i,j)) || help(s.substring(i+1,j+1))){
                    return true;
                }else{
                    return false;
                }
            }else {
                i++;
                j--;
            }
        }
        return false;
    }

    public boolean help(String x) {
        if (null == x || x.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = x.length() - 1;
        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
