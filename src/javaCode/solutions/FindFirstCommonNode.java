package javaCode.solutions;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    //Node data type
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //暴力
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        while (pHead1 != null) {
            ListNode temp = find(pHead1, pHead2);
            if (temp != null)
                return temp;
            pHead1 = pHead1.next;
        }
        return null;
    }

    public ListNode find(ListNode p1, ListNode p2) {
        while (p2 != null) {
            if (p1.equals(p2))
                return p1;
            p2 = p2.next;
        }
        return null;
    }

    //
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1, p2 = pHead2;
        int l1 = 0;
        int l2 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
//        System.out.println(l1 + " " + l2);
        int d = l1 - l2;
        if (d == 0)
            return pHead1;
        else if (d < 0) {
            while (d < 0) {
                pHead2 = pHead2.next;
                d++;
            }
        }
        else {
            while (d > 0) {
                pHead1 = pHead1.next;
                d--;
            }
        }
        while (!pHead1.equals(pHead2)) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public static void main(String[] args) {
        FindFirstCommonNode f = new FindFirstCommonNode();
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
//        System.out.println(f.FindFirstCommonNode(p1, p2).val);
        System.out.println(f.FindFirstCommonNode2(p1, p2).val);
    }
}
