package javaCode.datastructure;

import java.util.Iterator;

//动态调整大小，可迭代泛型数组栈
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {  return N == 0;}
    public int size()        {  return N;}
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {  return i > 0;   }
        public Item next()       {  return a[--i];  }
        public void remove()     {                  }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        Iterator<String> i = stack.iterator();
        for (String s : stack)
            System.out.println(s);
        while (i.hasNext()) {
            String ss = i.next();
            System.out.println(ss);
        }
        System.out.println(stack.pop());
    }
}
