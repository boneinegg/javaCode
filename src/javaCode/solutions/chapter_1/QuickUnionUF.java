package javaCode.solutions.chapter_1;

public class QuickUnionUF {
    private int[] id;
    private int[] size;

    public QuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }

    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {    id[i] = j; size[j] += size[i];}
        else                   {    id[j] = i; size[i] += size[j];}
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        QuickUnionUF qf = new QuickUnionUF(6);
        qf.union(1, 2);
        qf.union(0, 1);
        qf.union(3, 4);
        qf.union(5, 3);
        for (int i = 0; i < 6; i++) {
            System.out.println(qf.id[i]);
        }
        qf.union(2, 5);
        for (int i = 0; i < 6; i++) {
            System.out.println(qf.id[i]);
        }
    }

}
