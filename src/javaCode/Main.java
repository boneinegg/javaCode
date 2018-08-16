package javaCode;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.time.LocalDate;
public class Main {

    public static long f(long n) {
        if (n == 0 || n == 1)
            return 1;
        return f(n - 1) + f(n - 2);
    }

    public static void count(long n) {
        long tmp = n - ((n >> 1) & 033333333333) - ((n >> 2) & 011111111111);
        System.out.println(((tmp + (tmp >> 3)) & 030707070707) % 63);
    }

    public static void main(String[] args) throws IOException {

	// write your code here
        count(f(7));
        count(f(9));

        LinkedList<String > linkedList = new LinkedList<>();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.push("ccc");
        linkedList.addFirst("ddd");

//        System.out.println(linkedList);
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s = br.readLine();
//        System.out.println(s);
        Scanner in = new Scanner(Paths.get("test.txt"), "UTF-8");
        System.out.println(in.nextLine());

        PrintWriter out = new PrintWriter("test.txt", "UTF-8");
        out.write("cccc");
        out.print("aaaa");
        out.close();
//        out.flush();
//        System.out.println(out.toString());
//        out.write('c');
//        out.print("test 123");
    }
}
