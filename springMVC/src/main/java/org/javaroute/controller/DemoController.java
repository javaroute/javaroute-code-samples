package org.javaroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/v1")
    public String demo1(){
      return "hello";
    }

    @RequestMapping(value="/v2",method = RequestMethod.POST)
    public String demo2(){
        return "hello";
    }
}
