package javaCode.solutions;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这
 * 个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 1.将matrix字符串模拟映射为一个字符矩阵(但并不实际创建一个矩阵)
 * 2.取一个boolean[matrix.length]标记某个字符是否已经被访问过。
 * 3.如果没找到结果，需要将对应的boolean标记值置回false,返回上一层进行其他分路的查找。
 */
public class PathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] marked = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, str, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] marked) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || marked[index] || matrix[index] != str[k])
            return false;
        if (k == str.length - 1)
            return true;
        marked[index] = true;
        if (hasPath(matrix, rows, cols, i-1, j, str, k+1, marked)
                || hasPath(matrix, rows, cols, i+1, j, str, k+1, marked)
                || hasPath(matrix, rows, cols, i, j-1, str, k+1, marked)
                || hasPath(matrix, rows, cols, i, j+1, str, k+1, marked)) {
            return true;
        }
        marked[index] = false;
        return false;
    }
}
