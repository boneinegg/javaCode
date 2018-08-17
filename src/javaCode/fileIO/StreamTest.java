package javaCode.fileIO;

import java.io.*;

public class StreamTest {
    public static void main(String[] args) {
        File f = new File("/home/vinzor/Desktop/test.txt");
//        try (FileOutputStream fos = new FileOutputStream(f)) {
//
//            byte[] data = {'s', 'w', 'r', 'a'};
//            fos.write(data);
//
//            byte[] all = new byte[(int) f.length()];
//            FileInputStream fis = new FileInputStream(f);
//            fis.read(all);
//            for (byte b : all)
//                System.out.println(b);
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //字符流读文件
//        try (FileReader fr = new FileReader(f)) {
//            char[] all = new char[(int) f.length()];
//            fr.read(all);
//            for (char c : all)
//                System.out.println(c);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //字符流写文件
        try (FileWriter fw = new FileWriter(f)) {
            String s = "af;faflagkgagas";

            char[] all = s.toCharArray();
            fw.write(all);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
