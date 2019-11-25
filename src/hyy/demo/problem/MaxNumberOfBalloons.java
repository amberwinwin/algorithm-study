package hyy.demo.problem;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * @author hyy
 * @version V2.0, 2019/11/22
 * @copyright
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        if (null == text || text.length() < 7) {
            return 0;
        }
        int[] table = new int['o' - 'a' + 1];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b' || text.charAt(i) == 'a' ||
                text.charAt(i) == 'l' || text.charAt(i) == 'o' ||
                text.charAt(i) == 'n') {
                table[text.charAt(i) - 'a'] += 1;
            }
        }
        if (table['n' - 'a'] < 1 || table['o' - 'a'] < 2 ||
            table['b' - 'a'] < 1 || table['l' - 'a'] < 2 ||
            table['a' - 'a'] < 1) {
            return 0;
        }
        int min = table['n' - 'a'] < table['b' - 'a'] ?
            (table['a' - 'a'] < table['b' - 'a'] ? table['b' - 'a'] : table['a' - 'a']) :
            (table['a' - 'a'] < table['n' - 'a'] ? table['n' - 'a'] : table['a' - 'a']);
        int min2 = table['o' - 'a'] < table['l' - 'a'] ?
            table['o' - 'a'] : table['l' - 'a'];
        min2 /= 2;
        return Math.min(min,min2);
    }
}
