package com.baogex.demo.mv.caction;

import com.baogex.demo.IDemoService;
import com.baogex.mvcframework.annotation.BGAutowired;
import com.baogex.mvcframework.annotation.BGController;
import com.baogex.mvcframework.annotation.BGRequestMapping;
import com.sun.net.httpserver.HttpServer;

/**
 * <p>
 *
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
    public void query(HttpServerlet)
}
