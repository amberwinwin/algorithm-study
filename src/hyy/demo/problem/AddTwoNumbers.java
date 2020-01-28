package hyy.demo.problem;

import hyy.demo.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        List<Integer> list = new ArrayList<>();
        while (l1 != null || l2 != null) {
            a += l1 != null ? l1.val : 0;
            b += l2 != null ? l2.val : 0;
            if (a + b > 9) {
                list.add(a + b - 10);
                a = 1;
                b = 0;
            } else {
                list.add(a + b);
                a = 0;
                b = 0;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        ListNode res = new ListNode(list.remove(0));
        ListNode tmp = res;
        while (!list.isEmpty()) {
            tmp.next = new ListNode(list.remove(0));
            tmp = tmp.next;
        }
        if (a == 1) {
            tmp.next = new ListNode(1);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        addTwoNumbers(node1, node2);
    }
}
