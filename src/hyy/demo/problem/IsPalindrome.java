package hyy.demo.problem;

import hyy.demo.base.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode copy = null;
        ListNode tmp = head;
        while(tmp != null) {
            if (copy == null) {
                copy = new ListNode(tmp.val);
            }else{
                ListNode node = new ListNode(tmp.val);
                node.next = copy;
                copy = node;
            }
            tmp = tmp.next;
        }
        while (copy != null) {
            if (copy.val != head.val) {
                return false;
            }
            copy = copy.next;
            head = head.next;
        }
        return true;
    }
}
