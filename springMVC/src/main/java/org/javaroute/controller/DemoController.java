package org.javaroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一个controller可能包含多个接口方法，可以把请求前缀加在类上
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    /**
     * demo1
     */
    @RequestMapping("/v1")
    public String demo1(){
      return "hello";
    }

    /**
     * demo2请求方法限定，方法可以是一个也可以是多个
     */
    @RequestMapping(value="/v2",method = RequestMethod.POST)
    public String demo2(){
        return "hello";
    }
    /**
     * demo3请求方法限定，方法可以是一个也可以是多个
     */
    @RequestMapping(value="/v3",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
    public String demo3(){
        return "hello";
    }

    /**
     * 前后端不分离，大部分情况返回 ModelAndView，即数据模型+视图：
     */
    @RequestMapping("/v4")
    public ModelAndView demo4(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("info","javaroute");
        mv.setViewName("info");
        return mv;
    }

    /**
     *返回 Void 没有返回值，并不一定真的没有返回值，只是方法的返回值为 void，我们可以通过其他方式给前端返回。
     * 实际上，这种方式也可以理解为 Servlet 中的那一套方案。
     *
     * 服务端跳转
     */
    @RequestMapping("/v5")
    public void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/hello.jsp").forward(req,resp);//服务器端跳转
    }

    /**
     *返回 Void 没有返回值，并不一定真的没有返回值，只是方法的返回值为 void，我们可以通过其他方式给前端返回。
     * 实际上，这种方式也可以理解为 Servlet 中的那一套方案。
     *
     * 客户端重定向
     */
    @RequestMapping("/v6")
    public void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/hello.jsp");//客户端重定向
    }
    /**
     *返回 Void 没有返回值，并不一定真的没有返回值，只是方法的返回值为 void，我们可以通过其他方式给前端返回。
     * 实际上，这种方式也可以理解为 Servlet 中的那一套方案。
     *
     * 自己手动指定响应头去实现重定向：
     */
    @RequestMapping("/v7")
    public void demo7(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(302);
        resp.addHeader("Location", "/jsp/hello.jsp");
    }
    /**
     *返回 Void 没有返回值，并不一定真的没有返回值，只是方法的返回值为 void，我们可以通过其他方式给前端返回。
     * 实际上，这种方式也可以理解为 Servlet 中的那一套方案。
     *
     * 这种方式，既可以返回 JSON，也可以返回普通字符串。
     */
    @RequestMapping("/v8")
    public void demo8(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("hello javaroute!");
        out.flush();
        out.close();
    }
}
