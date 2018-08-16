package javaCode.solutions.chapter_1;

public class Sol11_12 {

    public static void printBooleanMatrix(boolean[][] matrix) {
        System.out.print(' ');
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        boolean[][] a = { { true, false, true }, { false, true, false },
//                { true, true, false } };
//        printBooleanMatrix(a);
//    }
    public static void main(String[] args) {
        boolean[][] a = {{false, true, false, true}, {false, false, false, true}};
        System.out.print(" ");
        for (int i = 0; i < a[0].length; i++)
            System.out.print(i + 1);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j])
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }


        //Sol12
        int[] aa = new int[10];
        for (int i = 0; i < 10; i++) {
            aa[i] = 9 - i;
            System.out.print(aa[i]);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            aa[i] = aa[aa[i]];
            System.out.print(aa[i]);
        }
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.print(aa[i]);
    }
}
