package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
        sb.append("package com.baogex.architect.base.source.spring5.gof.proxy.dyn;" + ln)
                .append("import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Person;" + ln)
                .append("import java.lang.reflect.*;" + ln)
                .append("public class $Proxy0 implements " + interafaces[0].getName() + "{" + ln)
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
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type).append(" ").append(paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName()).append(".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramValues.append(",");
                    paramClasses.append(",");
                }
            }
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" +
                    paramNames.toString() + "){" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interafaces[0].getName() + ".class.getMethod" +
                    "(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") +
                    getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex_){");
            sb.append("}catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        System.out.println(sb);
        return sb.toString();
    }

    private static final Map<Class, Class> mappings = new HashMap<>();

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnType) {
        if (mappings.containsKey(returnType)) {
            return "return 0";
        } else if (returnType == void.class) {
            return "";
        } else {
            return "return null";
        }
    }

    private static boolean hasReturnValue(Class<?> returnType) {
        return returnType != void.class;
    }

    private static Object getCaseCode(String code, Class<?> returnType) {
        if (mappings.containsKey(returnType)) {
            return "((" + mappings.get(returnType).getName() + ")" + code + ")." +
                    returnType.getSimpleName() + "Value()";
        }
        return code;
    }

    private static final int ASCLL_UP_A = 65;
    private static final int ASCLL_UP_Z = 90;

    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        if (chars.length > 0) {
            char first = chars[0];
            if (first >= ASCLL_UP_A && first <= ASCLL_UP_Z) {
                chars[0] = (char) (first + 32);
            }
            return new String(chars);
        }
        return simpleName;
    }
}
