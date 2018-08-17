package javaCode.fileIO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/home/vinzor/Desktop");
        System.out.println(file1.getAbsolutePath());

        File file2 = new File("file2.txt");
        System.out.println(file2.getAbsolutePath());


        File file= new File(file1, "file.txt");
        System.out.println(file.getAbsolutePath());

        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        file.createNewFile();

        System.out.println("文件：" + file);
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("文件长度：" + file.length());
        long time = file.lastModified();
        Date d = new Date(time);
        System.out.println("最后修改时间：" + d);
        file.setLastModified(0);

        //重命名
        File newFile = new File(file1, "test.txt");
        file.renameTo(newFile);
        for (File tmp : file1.listFiles())
            System.out.println(tmp.getName() + " " + tmp.length());
    }
}
