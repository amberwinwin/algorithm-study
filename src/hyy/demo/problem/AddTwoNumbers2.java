package hyy.demo.problem;

import hyy.demo.base.ListNode;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int a = 0, b = 0;
        ListNode res = null;
        ListNode temp = res;
        while (l1 != null || l2 != null) {
            a += l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            if (a + b > 9) {
                if (temp == null) {
                    res = new ListNode(a + b - 10);
                    a = 1;
                    temp = res;
                } else {
                    temp.next = new ListNode(a + b - 10);
                    a = 1;
                    temp = temp.next;
                }
            } else {
                if (res == null) {
                    res = new ListNode(a + b);
                    temp = res;
                    a = 0;
                } else {
                    temp.next = new ListNode(a + b);
                    temp = temp.next;
                    a = 0;
                }
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (a == 1){
            temp.next = new ListNode(1);
        }
        res = reverse(res);
        return res;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            if (next == null) {
                break;
            }
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(4);
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(3);
        addTwoNumbers(head2, head);
    }
}
