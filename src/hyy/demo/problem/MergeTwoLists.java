package hyy.demo.problem;

import hyy.demo.base.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode tmp = null;
        int a, b;
        while (null != l1 || null != l2) {
            a = l1 == null ? Integer.MAX_VALUE : l1.val;
            b = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (a < b) {
                if (res == null) {
                    res = new ListNode(a);
                    tmp = res;
                } else {
                    tmp.next = new ListNode(a);
                    tmp = tmp.next;
                }
                l1 = l1.next;
            } else {
                if (res == null) {
                    res = new ListNode(b);
                    tmp = res;
                } else {
                    tmp.next = new ListNode(b);
                    tmp = tmp.next;
                }
                l2 = l2.next;
            }
        }
        return res;
    }
}
