package javaCode.datastructure;


import java.util.Queue;

class LinkQueue {
    private FirstLastLink firstLastLink;
    public LinkQueue() {
        firstLastLink = new FirstLastLink();
    }

    public void push(int data) {
        firstLastLink.insertLast(data);
    }

    public int pop() {
        return firstLastLink.deleteFirst();
    }

    public boolean isEmpty() {
        return firstLastLink.isEmpty();
    }

    public void show() {
        firstLastLink.show();
    }
}

//双端链表
public class FirstLastLink {
    private Link first;
    private Link last;

    //节点结构
    class Link {
        int data;
        Link next;

        public Link(int data) {
            this.data = data;
        }

        public void show() {
            System.out.print(data + " ");
        }
    }

    public FirstLastLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void show() {
        Link tmp = first;
        while (tmp != null) {
            tmp.show();
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        }
        else {
            last.next = newLink;
        }
        last = newLink;
    }

    public int deleteFirst() {
        int tmp = first.data;
        if (first.next == null)
            last = null;
        first = first.next;
        return tmp;
    }

    public static void main(String[] args) {
        FirstLastLink fll = new FirstLastLink();
        fll.insertFirst(1);
        fll.insertLast(2);
        fll.insertFirst(3);
        fll.insertLast(4);
        fll.show();
        fll.deleteFirst();

        LinkQueue queue = new LinkQueue();
        queue.push(3);
        queue.push(5);
        queue.push(4);
        queue.show();
        queue.pop();
        queue.pop();
        queue.show();
    }
}
