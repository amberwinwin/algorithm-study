package hyy.demo.problem;

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k
 * 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2 输出: "bacdfeg" 要求:
 *
 * 该字符串只包含小写的英文字母。 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * @author hyy
 * @version V2.0, 2020/1/1
 * @copyright
 */
public class ReverseStr {

    public static String reverseStr(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        // 帮忙定位第几段2k
        int pos = 2 * k;
        char[] table = new char[len];
        for (int i = 0; i < len; i++) {
            table[i] = s.charAt(i);
        }
        int start = 0;
        while (true) {
            if (len-start >= 2*k) {
                handle(table,start,k);
                start = pos;
            }else if (len-start < k){
                handle(table,start,len-start);
                break;
            }else{
                handle(table,start,k);
                break;
            }
            pos += 2*k;
        }
        StringBuilder sb = new StringBuilder();
        for (char ele : table) {
            sb.append(ele);
        }
        return sb.toString();
    }

    public static void handle(char[] table, int start, int diff) {
        if (diff == 0) {
            return;
        }
        // diff是这段数组总长度 start是这段数组起始位置
        char tmp;
        for (int i = start; i < start + diff / 2; i++) {
            tmp = table[i];
            table[i] = table[2*start+diff-i-1];
            table[2*start+diff-i-1] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcd", 3));
    }
}
