package javaCode.solutions;

/**
 *  Sort a linked list in O(n log n) time using constant space complexity.
 *  Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * 归并排序
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(head2));
    }

    public ListNode merge(ListNode p, ListNode q) {
        ListNode first = new ListNode(0);
        ListNode last = first;
        while (p != null || q != null) {
            if (p != null && (q ==null || p.val <= q.val)) {
                last.next = p;
                last = last.next;
                p = p.next;
            }
            if (q != null && (p ==null || p.val > q.val)) {
                last.next = q;
                last = last.next;
                q = q.next;
            }
        }
        last.next = null;
        return first.next;
    }
}
