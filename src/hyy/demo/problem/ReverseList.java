package hyy.demo.problem;

import hyy.demo.base.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 *
 * @author hyy
 * @version V2.0, 2019/11/20
 * @copyright
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            if (null == next) {
                break;
            }
            pre = head;
            head = next;
        }
        return head;
    }
}
