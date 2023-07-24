package com.bowen.community.controller;

import com.bowen.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller

//类路径可以省略
@RequestMapping("/alpha")
public class AlphaConroller {
    //这些注解用于帮助浏览器获取路径
    @RequestMapping("/hello")
    @ResponseBody
    //该注解是为了让网页不跳转到预定路径HTML，直接显示方法返回值
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/data")
    @ResponseBody
    public String useService(){
        return alphaService.useDao();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据的一些部分
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " " + value);
        }
        System.out.println(request.getParameter("code"));

        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter printWriter = response.getWriter()) {
            printWriter.write("<hi>GBW</hi>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //GET请求的两种传参方式：向服务器请求数据

    //例：/student?current=a&limit=b
    //指定只有GET方法能唤醒
    @RequestMapping(path = "/student", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);

        return "Yifan Guo";
    }

    //例：/student/123参数是路径的一部分
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);

        return "Yifan Guo is an sb";
    }

    //POST：浏览器向服务器提交数据
    @RequestMapping(path = "/addstudent", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name){
        System.out.println(name);

        return "success";
    }

    //响应HTML
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        //返回值中封装了MVC中的model和view
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","GYF");
        modelAndView.addObject("age","24");
        modelAndView.setViewName("/demo/view");

        return modelAndView;
    }

    //简单的方式,传入model参数（该参数由前端控制器自动生成），再填入信息返回view。效果相同
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","GYF?");
        model.addAttribute("age","24?");
        return "/demo/view";
    }

    //响应Json数据，一般在异步请求中（即网页不刷新时访问了服务器）
    //将JAVA对象转换为JS对象的方式：Json字符串
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    //会自动转为Json在浏览器上显示
    public Map<String,Object> setEmp(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "GYF");
        map.put("age", "24");
        return map;
    }

}
