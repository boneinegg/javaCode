package javaCode.solutions;



class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
public class LinkedListLoop {
    public static void findLoop(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == head)
                break;
        }
        if (fast != null && fast.next != null)
            System.out.println("yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node1;
        findLoop(node1);
    }
}
