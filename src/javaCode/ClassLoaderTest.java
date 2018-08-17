package javaCode;

import java.io.IOException;
import java.io.InputStream;


//类与类加载器
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object1 = myloader.loadClass("javaCode.ClassLoaderTest").newInstance();
        System.out.println(object1.getClass());
        System.out.println(object1 instanceof javaCode.ClassLoaderTest);

        Object object2 = new ClassLoaderTest();
        System.out.println(object2.getClass());
        System.out.println(object2 instanceof javaCode.ClassLoaderTest);

    }
}
