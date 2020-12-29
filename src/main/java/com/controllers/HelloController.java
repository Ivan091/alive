package com.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public ModelAndView greeting(
            @RequestParam(name = "name", required = false, defaultValue = "<blank>") String name,
            @RequestParam(name = "greeting", required = false, defaultValue = "<blank greeting>") String greeting) {

        return new ModelAndView("greeting", Map.of("name", name, "greeting", greeting));
    }
}
