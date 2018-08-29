package javaCode.solutions;

import java.util.HashMap;

public class RandomListNodeSolution {

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //use HashMap
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        
        RandomListNode p = pHead;
        RandomListNode head = new RandomListNode(-1);
        RandomListNode q = head;

        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            hashMap.put(p, temp);

            q.next = temp;
            q = q.next;
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                RandomListNode value = hashMap.get(p);
                RandomListNode random = p.random;
                value.random = random;
            }
            p = p.next;
        }
        return head;
    }

    //
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null)  return null;
        RandomListNode p = pHead;
//        RandomListNode q =
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        RandomListNode head = pHead.next;
        RandomListNode q = head;
        p = pHead;
        while (q.next != null) {
            p.next = q.next;
            p = p.next;

            q.next = p.next;
            q = q.next;
        }
        p.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
