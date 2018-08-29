package javaCode.algs.search;

import javaCode.datastructure.Queue;

import java.util.NoSuchElementException;

/**
 * uses two arrays to implement symbol table
 * @param <Key>
 * @param <Value>
 */
@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        keys = tempk;
        values = tempv;
    }

    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    /**
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");

        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(keys[mid]) < 0) hi = mid - 1;
            else if (key.compareTo(keys[mid]) > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }

        int i = rank(key);
        //already in table
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }

        //insert new pair
        if (n == keys.length) resize(n * 2);

        for (int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
        assert check();
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("first argument to delete() is null");
        if (isEmpty()) return;

        //compute rank
        int i = rank(key);

        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++) {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        n--;
        keys[n] = null;
        values[n] = null;
        if (n > 0 && n == keys.length / 4) resize(keys.length / 2);
        assert check();
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }

    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        int i = rank(key);
//        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == n) return null;
        else return keys[i];
    }

    //number of keys in the specified range
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi))         return rank(hi) - rank(lo) + 1;
        else                      return rank(hi) - rank(lo);
    }

    //Iterator
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new Queue<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) queue.enqueue(hi);
        return queue;
    }

    //check internal invariants
    private boolean check() {
        return isSorted() && rankCheck();
    }
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        }
        return true;
    }
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) return false;
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        BinarySearchST st = new BinarySearchST();
        st.put("a", 0);
        st.put("b", 1);
        st.put("c", 2);
        System.out.println(st.size() + " " + st.isEmpty() + " " + st.contains("a"));
//        st.put("a", null);
//        st.display();
//        st.delete("c");
//        System.out.println();
//        st.display();
        System.out.println(st.min() + " " + st.max());
        System.out.println(st.floor("d"));
        System.out.println(st.ceiling("d"));
        for (String s : (Iterable<String>) st.keys()) {
            System.out.println(s);
        }

        st.deleteMax();
        st.deleteMin();
        for (String s : (Iterable<String>) st.keys()) {
            System.out.println(s);
        }

    }
}
