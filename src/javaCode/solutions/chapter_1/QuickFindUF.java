package javaCode.solutions.chapter_1;

public class QuickFindUF {
    private  int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(6);
        qf.union(1, 2);
        qf.union(0, 5);
        qf.union(2, 4);
        System.out.println(qf.connected(1, 4));
        System.out.println(qf.connected(1, 3));
    }
}
