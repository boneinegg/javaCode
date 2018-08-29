package javaCode.datastructure;

public class DoublyLinkList {
    private Link first;
    private Link last;

    public DoublyLinkList() {
        first = null;
        last = null;
    }

    class Link {
        int data;
        Link left;
        Link right;

        public Link(int data) {
            this.data = data;
        }

        public void show() {
            System.out.print(data + " ");
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            last = newLink;
        }
        else  {
            first.left = newLink;
        }
        newLink.right = first;
        first = newLink;
    }

    public void insertLast(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        }
        else {
            last.right = newLink;
        }
        newLink.left = last;
        last = newLink;
    }

    public Link deleteFirst() {
        Link tmp = first;
        if (first.right == null) {
            last = null;
        }
        else {
            first.right.left = null;
        }
        first = first.right;
        return tmp;
    }

    public Link deleteLast() {
        Link tmp = last;
        if (last.left == null) {
            first = null;
        }
        else {
            last.left.right = null;
        }
        last = last.left;
        return tmp;
    }

    public boolean insertAfter(int key, int data) {
        Link curr = first;
        while (curr != null && curr.data != key) {
            curr = curr.right;
            if (curr == null)
                return false;
        }

        Link newLink = new Link(data);
        if (curr == last) {
            newLink.right = null;
            last = newLink;
        }
        else {
            newLink.right = curr.right;
            curr.right.left = newLink;
        }
        curr.right = newLink;
        newLink.left = curr;
        return true;
    }

    public Link delete(int key) {
        Link curr = first;
        while (curr != null && curr.data != key) {
            curr = curr.right;
            if (curr == null)
                return null;
        }
        if (curr == first) {
            first = first.right;
        }
        else {
            curr.left.right = curr.right;
        }
        if (curr == last) {
            last = last.left;
        }
        else {
            curr.right.left = curr.left;
        }
        return curr;
    }

    public void showForward() {
        Link curr = first;
        while (curr != null) {
            curr.show();
            curr = curr.right;
        }
        System.out.println();
    }

    public void showBackward() {
        Link curr = last;
        while (curr != null) {
            curr.show();
            curr = curr.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkList dll = new DoublyLinkList();
        dll.insertFirst(1);
        dll.insertLast(2);
        dll.insertAfter(1, 3);
        dll.insertAfter(3, 4);
        dll.showForward();
        dll.showBackward();
        dll.deleteFirst();
        dll.showBackward();
        dll.deleteLast();
        dll.showForward();
        dll.delete(3);
        dll.showForward();
    }
}

