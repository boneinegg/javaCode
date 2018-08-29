package javaCode.solutions;

import java.util.ArrayList;

/**
 *
 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

 */
public class EntryNodeOfLoop {

    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ArrayList<ListNode> al = new ArrayList<>();
        while (pHead != null) {
            if (al.contains(pHead)) {
                return pHead;
            }
            al.add(pHead);
            pHead = pHead.next;
        }
        return pHead;
    }

    public static ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode p = pHead, q = pHead;
        while (p != null && q != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                p = pHead;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                if (p == q)
                    return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        if (EntryNodeOfLoop(l1) != null)
            System.out.println(EntryNodeOfLoop(l1).val);
        if (EntryNodeOfLoop2(l1) != null)
            System.out.println(EntryNodeOfLoop2(l1).val);
    }
}
