package javaCode.datastructure;

public class OrderArray {
    private long[] orderArray;
    private int length = 0; // 数组元素个数

    //构造
    public OrderArray(int size) {
        orderArray = new long[size];
    }

//    返回数组长度
    public int length() {
        return length;
    }

    //插入，增加数组长度
    public void insert(long item) {
        int i;
        for (i = 0; i < length; i++) {
            if (item < orderArray[i]) {
                break;
            }
        }
        for (int j = length; j > i; j--) {
            orderArray[j] = orderArray[j - 1];
        }
        orderArray[i] = item;
        length++;
    }

    //    二分查找
    public int find(long item) {
        int low = 0, high = length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (orderArray[mid] == item) {
                return mid;
            }
            else if (orderArray[mid] < item) {
                low = mid + 1;
            }
            else
                high = mid -1;
        }
        return -1;
    }


    //递归二分查找
    public int findByRecursive(long item) {
        return recFind(item, 0, length - 1);
    }

    public int recFind(long item, int low, int high) {
        int mid;
        mid = (low + high) / 2;
        if (item == orderArray[mid])
            return mid;
        else if (low > high)
            return -1;
        else {
            if (orderArray[mid] > item)
                return recFind(item, low, mid - 1);
            else
                return recFind(item, mid + 1, high);
        }
    }

    //删除元素并移动数组
    public boolean delete(long item) {
        int i = 0;
        for (i = 0; i < length; i++) {
            if (item == orderArray[i]) {
                break;
            }
        }
        i = find(item);
        if (i == -1)
            return false;
        for (int j = i; j < length - 1; j++) {
            orderArray[j] = orderArray[j + 1];
        }
        length--;
        return true;
    }

    //    打印数组
    public void show() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i == length -1)
                System.out.print(orderArray[i]);
            else {
                System.out.print(orderArray[i] + ", ");
            }
        }
        System.out.print("]\n");
    }

//    // 构造方法，传入数组最大长度
//    public OrderArray(int max) {
//        intArray = new int[max];
//    }
//
//    // 用二分查找法定位某个元素，如果存在返回其下标，不存在则返回-1
//    public int find(int target) {
//        int lowerBound = 0; // 搜索段最小元素的小标
//        int upperBound = length - 1; // 搜索段最大元素的下标
//        int curIn; // 当前检测元素的下标
//
//        if (upperBound < 0) { // 如果数组为空，直接返回-1
//            return -1;
//        }
//
//        while (true) {
//            curIn = (lowerBound + upperBound) / 2;
//
//            if (target == intArray[curIn]) {
//                return curIn;
//            } else if (curIn == lowerBound) { // 在当前下标与搜索段的最小下标重合时，代表搜索段中只包含1个或2个元素
//                // 既然走到该分支，证明上一个if分支不满足，即目标元素不等于低位元素
//                if (target == intArray[upperBound]) { // 等于高位元素，返回
//                    return upperBound;
//                } else { // 高位元素也不等于目标元素，证明数组中没有该元素，搜索结束
//                    return -1;
//                }
//            } else {// 搜索段中的元素至少有三个，且当前元素不等于目标元素
//                if (intArray[curIn] < target) {
//                    // 如果当前元素小于目标元素，则将下一个搜索段的最小下标置为当前元素的下标
//                    lowerBound = curIn;
//                } else {
//                    // 如果当前元素大于目标元素，则将下一个搜索段的最大下标置为当前元素的下标
//                    upperBound = curIn;
//                }
//            }
//        }
//    }
//
//    // 插入
//    public void insert(int elem) {
//        int location = 0;
//
//        // 判断应插入位置的下标
//        for (; location < length; location++) {
//            if (intArray[location] > elem)
//                break;
//        }
//        // System.out.println(location);
//        // 将插入下标之后的所有元素后移一位
//        for (int i = length; i > location; i--) {
//            intArray[i] = intArray[i - 1];
//        }
//
//        // 插入元素
//        intArray[location] = elem;
//
//        length++;
//    }
//
//    // 删除某个指定的元素值，删除成功则返回true，否则返回false
//    public boolean delete(int target) {
//        int index;
//        if ((index = find(target)) != -1) {
//            for (int i = index; i < length - 1; i++) {
//                // 删除元素之后的所有元素前移一位
//                intArray[i] = intArray[i + 1];
//            }
//            length--;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    // 列出所有元素
//    public void display() {
//        for (int i = 0; i < length; i++) {
//            System.out.print(intArray[i] + "\t");
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        OrderArray orderArray = new OrderArray(5);
        orderArray.insert(5);
        orderArray.insert(6);
        orderArray.insert(8);
//        orderArray.insert(9);
        orderArray.show();
        int index = orderArray.find(6);
        index = orderArray.findByRecursive(0);
        if (index != -1)
            System.out.println("找到了，下标是" + index);
        else
            System.out.println("没找到");
        System.out.println(orderArray.delete(6));
        orderArray.show();
    }
}