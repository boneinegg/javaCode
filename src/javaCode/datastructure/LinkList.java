package javaCode.datastructure;

import java.lang.management.LockInfo;
import java.util.LinkedList;


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

public class LinkList {
    private Link head;

    public boolean isEmpyt() {
        return (head == null);
    }


    //迭代器
    public Link getHead() {
        return head;
    }

    public void setHead(Link head) {
        this.head = head;
    }

    public LinkIterator getInterator() {
        return new LinkIterator(this);
    }

    //有序链表
    public void insertOrdered(int data) {
        Link curr = head;
        Link pre = null;
        Link newLink = new Link(data);
        while (curr != null && curr.data < data) {
            pre = curr;
            curr = curr.next;
        }
        if (pre == null)
            head = newLink;
        else
            pre.next = newLink;
        newLink.next = curr;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.next = head;
        head = newLink;
    }

    public int deleteFirst() {
        int tmp = head.data;
        head = head.next;
        return tmp;
    }

    public Link find(int key) {
        Link tmp = head;
        while (tmp != null) {
            if (tmp.data == key)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }


    //删除特定值
    public Link delete(int key) {
        Link curr = head;
        Link pre = head;
        while (curr.data != key) {
            if (curr.next == null)
                return null;
            else {
                pre = curr;
                curr = curr.next;
            }
        }
        if (curr == head)
            head = head.next;
        else pre.next = curr.next;
        return curr;
    }

    public void show() {
        Link tmp = head;
        System.out.println();
        while (tmp != null) {
            tmp.show();
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("链表测试： ");
        LinkList ll = new LinkList();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.show();
        ll.find(1).show();
        ll.deleteFirst();
        ll.delete(1).show();
        ll.show();
        System.out.println(ll.isEmpyt());


        //有序链表测试
        System.out.println("有序链表测试： ");
        LinkList linkList = new LinkList();
        linkList.insertOrdered(4);
        linkList.insertOrdered(5);
        linkList.insertOrdered(3);
        linkList.insertOrdered(2);
        linkList.show();

        //链表栈测试
        System.out.println("链表栈测试： ");
        LinkStack stack = new LinkStack();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.show();
        stack.pop();
        stack.show();

        //迭代器测试
        System.out.println("迭代器测试：");
        LinkIterator lt1 = new LinkIterator(linkList);
        LinkIterator lt2 = linkList.getInterator();
        lt1.nextLink();
        lt2.nextLink();
        lt1.getCurr().show();
        lt2.getCurr().show();
        lt2.reset();
        lt2.getCurr().show();
        lt2.insertAfter(6);//插入后指向新节点
        lt2.insertBefore(7);
        linkList.show();
        System.out.println(lt2.atEnd());

    }
}

//链表实现的栈
class LinkStack {
    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(int data) {
        linkList.insertFirst(data);
    }

    public int pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpyt();
    }

    public void show() {
        linkList.show();
    }
}

class LinkIterator {
    private LinkList linkList;
    private Link curr;
    private Link pre;

    public LinkIterator(LinkList linkList) {
        this.linkList = linkList;
        reset();
    }

    public boolean atEnd() {
        return curr.next == null;
    }

    public void reset() {
        curr = linkList.getHead();
        pre = null;
    }

    public void nextLink() {
        pre = curr;
        curr = curr.next;
    }

    public Link getCurr() {
        return curr;
    }

    public void insertBefore(int data) {
        Link newLink = new Link(data);
        if (pre == null) {
            newLink.next = linkList.getHead();
            linkList.setHead(newLink);
            reset();
        }
        else {
            pre.next = newLink;
            newLink.next = curr;
            curr = newLink;
        }
    }

    public void insertAfter(int data) {
        Link newLink = new Link(data);

        if (linkList.isEmpyt()) {
            linkList.setHead(newLink);
            curr = newLink;
        }
        else {
            newLink.next = curr.next;
            curr.next = newLink;
            nextLink();
        }
    }

    public int deleteCurr() {
        Link tmp = curr;
        if (pre == null) {
            linkList.setHead(curr.next);
            reset();
        }
        else {
            pre = curr.next;
            if (atEnd()) {
                reset();
            }
            else {
                curr = curr.next;
            }
        }
        return tmp.data;
    }
}