package javaCode.algs.search;

import javaCode.datastructure.Queue;

import java.util.Iterator;

//uses unordered Linked-list to implement symbol table
public class SequentialSearchST<Key, Value> {
    private Node first; //the linked list of key-value pairs
    private int n;      //number of key-value pairs

    //a helper linked list data type
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {

    }

    /**
     * Returns the value associated with the given key in this symbol table.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table and null if not.
     * @throws IllegalArgumentException if key is null
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.value;
        }
        return null;
    }

    /**
     * Returns true if the given key is in the symbol table and false if not.
     * @param key the key
     * @return true if this symbol table contains {@code key}; false otherwise.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Puts the specified key-value pair into the symbol table, overwriting the old value with the
     * new value if the symbol table already contains the specified value.
     * Deletes the specified key and its associated value from this symbol table if the specified value is null.
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Deletes the specified key-value pair from this symbol table if the key is in this symbol table.
     * @param key the key
     * @throws IllegalArgumentException if key is null.
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }
    //delete the key in linked list beginning at Node x.
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public void display() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.key + ": " + x.value);
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("a", 0);
        st.put("b", 1);
        st.put("c", 2);
        st.display();
        System.out.println(st.size() + " " + st.isEmpty() + " " + st.contains("a"));
//        st.put("a", null);
//        st.display();
//        st.delete("c");
//        System.out.println();
//        st.display();

        Iterator<String> iterator = st.keys().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
