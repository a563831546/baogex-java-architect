package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import java.io.*;

/**
 * <p>
 * baogex类加载器
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-29
 */
public class BGClassLoader extends ClassLoader {

    private final File classPathFile;

    public BGClassLoader() {
        classPathFile = new File(BGClassLoader.class.getResource("").getPath());
    }

    @Override
    protected Class<?> findClass(String className) {
        String classPackagePath = BGClassLoader.class.getPackage().getName() + "." + className;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, className.replace("\\.", "/") + ".class");
            if (classFile.exists()) {
                try (FileInputStream fileInputStream = new FileInputStream(classFile);
                     ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                    int len;
                    byte[] buff = new byte[1024];
                    while ((len = fileInputStream.read(buff)) != -1) {
                        outputStream.write(buff, 0, len);
                    }
                    return defineClass(classPackagePath, outputStream.toByteArray(), 0, outputStream.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        final BGClassLoader bgClassLoader = new BGClassLoader();
        final Class<?> aClass = bgClassLoader.findClass("BGProxy");
        System.out.println("dasd");
    }
}
