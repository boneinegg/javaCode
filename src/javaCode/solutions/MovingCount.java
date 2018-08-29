package javaCode.solutions;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] marked = new boolean[rows][cols];
        return movingCount(threshold, rows, cols, 0, 0, marked);
    }

    public int movingCount(int t, int rows, int cols, int i, int j, boolean[][] marked) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || !canMove(i, j, t) || marked[i][j])
            return 0;
        marked[i][j] = true;
        return movingCount(t, rows, cols, i+1, j, marked)
                + movingCount(t, rows, cols, i-1, j, marked)
                + movingCount(t, rows, cols, i, j+1, marked)
                + movingCount(t, rows, cols, i, j-1, marked)
                + 1;
    }

    public boolean canMove(int i, int j, int k) {
        int p= 0;
        while (i != 0) {
            p += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            p += j % 10;
            j /= 10;
        }
        return p <= k;
    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        System.out.println(mc.movingCount(15, 20, 20));

    }
}
