package javaCode.solutions;

/**
 *  Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head, next;
        ListNode first = new ListNode(0);
        ListNode pre = first;
        while (curr != null) {
            next = curr.next;

            while (pre.next != null && pre.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;

            pre = first;
            curr = next;
        }
        return first.next;
    }
}
