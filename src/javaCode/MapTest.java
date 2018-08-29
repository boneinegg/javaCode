package javaCode;

import java.util.*;

/**
 * 通用Map：用于在应用程序中管理映射，通常在 java.util 程序包中实现
 * HashMap、Hashtable、Properties、LinkedHashMap、IdentityHashMap、TreeMap、WeakHashMap、ConcurrentHashMap
 *
 * 专用Map：通常我们不必亲自创建此类Map，而是通过某些其他类对其进行访问
 * java.util.jar.Attributes、javax.print.attribute.standard.PrinterStateReasons、java.security.Provider、
 * java.awt.RenderingHints、javax.swing.UIDefaults
 *
 * 自行实现Map：一个用于帮助我们实现自己的Map类的抽象类
 * AbstractMap
 *
 *HashMap
 * 最常用的Map,它根据键的HashCode 值存储数据,根据键可以直接获取它的值，具有很快的访问速度。
 * HashMap最多只允许一条记录的键为Null(多条会覆盖);允许多条记录的值为 Null。非同步的。
 *
 * TreeMap
 * 能够把它保存的记录根据键(key)排序,默认是按升序排序，也可以指定排序的比较器，当用Iterator 遍历TreeMap时，
 * 得到的记录是排过序的。TreeMap不允许key的值为null。非同步的。
 *
 * Hashtable
 * 与 HashMap类似,不同的是:key和value的值均不允许为null;它支持线程的同步，即任一时刻只有一个线程能写Hashtable,
 * 因此也导致了Hashtale在写入时会比较慢。
 *
 * LinkedHashMap
 * 保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.
 * 在遍历的时候会比HashMap慢。key和value均允许为空，非同步的。
 */
public class MapTest {

    private static int size = 10;

    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        Map<String, String> m2 = new TreeMap<>();
        Map<String, String> m3 = new Hashtable<>();
        Map<String, String> m4 = new LinkedHashMap<>();
        init(m1);
        printIterEntrySet(m1);
        sort(m1);
        printForEntrySet(m1);
//        init(m2);
//        init(m3);
//        init(m4);
    }

    public static void init(Map<String, String> map) {
        //随机插入
        for (int i = 0; i < size; i++) {
            map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
    }

    public static void printForKeySet(Map<String, String> map) {
        /**
         *
         增强for循环使用方便，但性能较差，不适合处理超大量级的数据。

         迭代器的遍历速度要比增强for循环快很多，是增强for循环的2倍左右。

         使用entrySet遍历的速度要比keySet快很多，是keySet的1.5倍左右。
         */
        //foreach使用keySet()遍历
        for (String s : map.keySet())
            System.out.println(s + " " + map.get(s));
    }

    public static void printForEntrySet(Map<String, String> map) {
        //foreach使用entrySet()遍历
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    public static void printIterKeySet(Map<String, String> map) {
        //迭代器使用keySet()遍历
        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void printIterEntrySet(Map<String, String> map) {
        //迭代器使用entrySet()遍历
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> entry = iterator2.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * HashMap、Hashtable、LinkedHashMap排序
     * 注：TreeMap也可以使用此方法进行排序，但是更推荐sortTreeMap方法。
     * @param map
     */
    public static void sort(Map<String, String> map) {
        //通过ArrayList构造函数把map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

        //重载比较器
        list.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        //默认lambda表达式
        list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        //简化lambda表达式
        list.sort(Comparator.comparing(Map.Entry::getKey));
    }

    public static void sortTreeMap() {
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Map<String, String> map1 = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

        Map<String, String> map2 = new TreeMap<>(Comparator.naturalOrder());

        Map<String, String> map3 = new TreeMap<>(String::compareTo);
    }

    //按values排序
    public static void sortByValue(Map<String, String> map) {
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

        //普通写法
        list.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //lambda表达式
        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        list.sort(Comparator.comparing(Map.Entry::getValue));

        //使用Collections
//        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
    }
}
