package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.StdIn;

public class Sol13 {
    public static void transposeMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMartix = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j ++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int M = StdIn.readInt();
        int N = StdIn.readInt();
        if (M == 0 || N == 0)
            return;
        int[][] b = new int[M][N];
//        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}};
//        transposeMatrix(a);
        transposeMatrix(b);
    }
}
