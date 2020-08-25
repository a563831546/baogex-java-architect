package com.baogex.demo.mv.caction;

import com.baogex.demo.IDemoService;
import com.baogex.mvcframework.annotation.BGAutowired;
import com.baogex.mvcframework.annotation.BGController;
import com.baogex.mvcframework.annotation.BGRequestMapping;
import com.baogex.mvcframework.annotation.BGRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 算法 
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-21
 */
@BGController
@BGRequestMapping("/demo")
public class DemoAction {
    @BGAutowired
    private IDemoService demoService;

    @BGRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @BGRequestParam("name") String name) {
        String result = demoService.get(name);
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BGRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp,
                    @BGRequestParam("a") Integer a, @BGRequestParam("b") Integer b) {
        try {
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BGRequestMapping("/remove")
    public void remove(HttpServletRequest req, HttpServletResponse resp,
                       @BGRequestParam("id") Integer id) {
        try {
            resp.getWriter().write("remove id = " + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
