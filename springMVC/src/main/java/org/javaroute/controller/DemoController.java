package org.javaroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/demo")
@Controller
public class DemoController {
    @RequestMapping("/v1")
    public String demo1(){
      return "hello";
    }
}
