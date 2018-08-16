package javaCode.datastructure;

public class Array {
    private long[] array;
    private int length = 0;

    //构造
    public Array(int size) {
        array = new long[size];
    }

    //插入，增加数组长度
    public void insert(long item) {
        array[length++] = item;
    }

//    查找
    public boolean find(long item) {
        for (int i = 0; i < length; i ++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

//    查找返回下标或-1
    public int indexOf(long item) {
        for (int i = 0; i < length; i ++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    //删除元素并移动数组
    public boolean delete(long item) {
        int i = 0;
        for (i = 0; i < length; i++) {
            if (item == array[i]) {
                break;
            }
        }
        if (i == length)
            return false;
        for (int j = i; j < length - 1; j++) {
            array[j] = array[j + 1];
        }
        length--;
        return true;
    }

//    打印数组
    public void show() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i == length -1)
                System.out.print(array[i]);
            else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(1);
        array.insert(2);
        array.show();
        System.out.println(array.length);
        int index = array.indexOf(2);
        if (array.find(2) && index != -1)
            System.out.println("找到了");
        else
            System.out.println("没找到");
        if (array.delete(2))
            System.out.println("删除了");
        else
            System.out.println("没找到");

    }
}

//
//public class Array {
//
//    private String [] strArray;
//    private int length = 0;       //数组元素个数
//
//    //构造方法，传入数组最大长度
//    public Array(int max){
//        strArray = new String [max];
//    }
//
//    //检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
//    public int contains(String target){
//        int index = -1;
//        for(int i=0;i<length;i++){
//            if(strArray[i].equals(target)){
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
//
//    //插入
//    public void insert(String elem) {
//        strArray[length] = elem;
//        length++;
//    }
//
//    //删除某个指定的元素值，删除成功则返回true，否则返回false
//    public boolean delete(String target){
//        int index = -1;
//        if((index = contains(target)) !=-1){
//            for(int i=index;i<length-1;i++){
//                //删除元素之后的所有元素前移一位
//                strArray[i] =strArray[i+1];
//            }
//            length--;
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    //列出所有元素
//    public void display(){
//        for(int i=0;i<length;i++){
//            System.out.print(strArray[i]+"\t");
//        }
//    }
//
//    public static void main(String[] args) {
//        Array a = new Array(10);
//        a.insert("a");
//        a.insert("b");
//        a.display();
//        System.out.println(a.contains("a"));
//        System.out.println(a.delete("a"));
//
//    }
//}
