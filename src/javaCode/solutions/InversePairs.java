package javaCode.solutions;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 输入描述:
 *
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 *
 * 1,2,3,4,5,6,7,0
 *
 * 输出
 *
 * 7
 *
 * 解题思路：归并排序（自上而下）合并过程中计数逆序对
 */
public class InversePairs {
    private int count;

    public int InversePairs(int [] array) {

//暴力不可取
//        int count = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] > array[j])
//                    count++;
//            }
//        }
//        return count % 1000000007;
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length-1);
        return count;
    }

    public void sort(int[] array, int[] aux, int lo, int hi) {
        if (lo >= hi)   return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);

        merge(array, aux, lo, mid, hi);
    }

    public void merge(int[] array, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            }
            else if (j > hi) {
                array[k] = aux[i++];
            }
            else if (aux[i] < aux[j]) {
                array[k] = aux[i++];
            }
            else {
                array[k] = aux[j++];
                //计数，求模防溢出
                count += mid - i + 1;
                count %= 1000000007;
            }
        }
    }

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();
        //2519
        int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,
                965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,
                882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,
                870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(ip.InversePairs(array));
    }
}
