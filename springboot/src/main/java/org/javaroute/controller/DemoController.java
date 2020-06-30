package org.javaroute.controller;

import org.javaroute.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1(){
         return  this.appVersion;
    }
    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(){
      return appConfig.toString();
    }
}
