package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <p>
 * 代理类
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-29
 */
public class BGProxy {
    public static final String ln = "\r\n";

    public static Object newProxyInstance(BGClassLoader classLoader, Class<?>[] interafaces, BGInvocationHandler handler) {
        try {
            String src = generateSrc(interafaces);
            final String filePath = BGProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
            task.call();
            manager.close();

            Class<?> proxy = classLoader.findClass("$Proxy0");
            Constructor<?> constructor = proxy.getConstructor(BGInvocationHandler.class);
            file.delete();
            return constructor.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 架子资源文件 SynapseRT Add On : License expired or Invalid! Please contact your Administrator
     *
     * @param interafaces
     * @return
     */
    private static String generateSrc(Class<?>[] interafaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("com.baogex.architect.base.source.spring5.gof.proxy.dyn;" + ln)
                .append("import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Person;" + ln)
                .append("import java.lang.reflect.*;" + ln)
                .append("public class Proxy implements" + interafaces[0].getName() + "[" + ln)
                .append("BGInvocationHandler h; " + ln)
                .append("public $Proxy0(BGInvocationHandler h){" + ln)
                .append("this.h = h;" + ln)
                .append("}" + ln);
        for (Method m : interafaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];


            }
        }
        return "";
    }
}
