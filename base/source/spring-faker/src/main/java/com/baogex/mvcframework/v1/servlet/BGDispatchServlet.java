package com.baogex.mvcframework.v1.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-24
 */
public class BGDispatchServlet extends HttpServlet {
    private Map<String, Object> mapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        if (!mapping.containsKey(url)) {
            resp.getWriter().write("404 Not Found!!");
            return;
        }
        Method method = (Method) this.mapping.get(url);
        Map<String, String[]> parameterMap = req.getParameterMap();
        method.invoke(this.mapping.get(method.getDeclaringClass().getName()),
                req,resp,parameterMap.get("name")[0]);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        InputStream is= null;
        try {
            Properties properties=new Properties();
            is = this.getClass().getClassLoader()
                    .getResourceAsStream(config.getInitParameter("contextConfigLocation"));
            //真tm傻逼
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
