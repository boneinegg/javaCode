package javaCode.datastructure;

public class PriorityQueue {
    private int max;
    private int[] qArray;
    private int size;

    public PriorityQueue(int max) {
        this.max = max;
        qArray = new int[this.max];
        size = 0;
    }

    public void insert(int item) {
        int i;
        if (size == 0) {
            qArray[size++] = item;
        }
        else {
            for (i = size - 1; i >= 0; i--) {
                if (item > qArray[i])
                    qArray[i + 1] = qArray[i];
                else
                    break;
            }
            qArray[i + 1] = item;
            size++;
        }
    }

    public int remove() {
        return qArray[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void show() {
        for (int i = 0; i < size; i++)
            System.out.print(qArray[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(2);
        pq.insert(1);
        pq.insert(1);
        pq.show();
        System.out.println(pq.isEmpty() + " " + pq.isFull());
        System.out.println(pq.remove());
        pq.show();
    }
}
