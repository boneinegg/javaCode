package javaCode.solutions;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public static ListNode deleteDuplication2(ListNode pHead)
    {
       ListNode f = new ListNode(0);
       f.next = pHead;
       ListNode l = f, p = pHead;

       while (p != null && p.next != null) {
           if (p.val == p.next.val) {
               int val = p.val;
               while (p != null && p.val == val) {
                   p = p.next;
               }
               l.next = p;
//               p = p.next;
           }
           else {
               l = p;
               p = p.next;
           }
       }
       return f.next;
    }

    //递归
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;

        if (pHead.val == pHead.next.val) {
            ListNode p = pHead.next;
            while (p != null && p.val == pHead.val)
                p = p.next;
            return deleteDuplication(p);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l33 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l22;
        l22.next = l3;
        l3.next = l33;
        l33.next = l4;
        ListNode l = l1;
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
        System.out.println();

        l = deleteDuplication2(l1);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
