package javaCode.algs.search;

import javaCode.datastructure.Queue;

import java.util.NoSuchElementException;
import java.util.Scanner;

//Uses binary search tree to implement symbol table
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int N;

        private Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else           return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a invalid key");
        if (x == null) return null;
        if (key.compareTo(x.key) < 0) return get(x.left, key);
        else if (key.compareTo(x.key) > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        assert check();
    }
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        if (key == null)    throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty())      throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null)      return null;
        else                return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null)      return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)       return x;
        if (cmp < 0)        return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)      return t;
        else                return x;
    }

    public Key ceiling(Key key) {
        if (key == null)    throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty())      throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null)      return null;
        else                return x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null)      return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)       return x;
        if (cmp > 0)        return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)      return t;
        else                return x;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        if (x == null)      return null;
        int t = size(x.left);
        if (t > k)          return select(x.left, k);
        else if (t < k)     return select(x.right, k - t - 1);
        else                return x;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(root, key);
    }
    private int rank(Node x, Key key) {
        if (x == null)      return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return rank(x.left, key);
        else if (cmp > 0)   return 1 + size(x.left) + rank(x.right, key);
        else                return size(x.left);
    }


    ///delete
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null)     return x.right;
            if (x.right == null)    return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //Iterator
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<>();
        return keys(min(), max());
    }
    private Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmpl = lo.compareTo(x.key);
        int cmph = hi.compareTo(x.key);
        if (cmpl < 0)   keys(x.left, queue, lo, hi);
        if (cmpl <= 0 && cmph >= 0)    queue.enqueue(x.key);
        if (cmph > 0)   keys(x.right, queue, lo, hi);
    }

    //check
    private boolean check() {
        if (!isBST())
            System.out.println("Not in symmetric order");
        if (!isSizeConsistent())
            System.out.println("Subtree counts not consistent");
        if (!isRankConsistent())
            System.out.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }
    private boolean isBST() {
        return isBST(root, null, null);
    }
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null)  return true;
        if (min != null && x.key.compareTo(min) <= 0)   return false;
        if (max != null && x.key.compareTo(max) >= 0)   return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }
    private boolean isSizeConsistent(Node x) {
        if (x == null)  return true;
        if (x.N != size(x.left) + size(x.right) + 1)    return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i)))   return false;
        }
        for (Key key : keys()) {
            if (key.compareTo(select(rank(key))) != 0)  return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            bst.put(in.next(), i);
        }

        for (String s : bst.keys()) {
            System.out.println(s + ": " + bst.get(s));
        }
    }
}
