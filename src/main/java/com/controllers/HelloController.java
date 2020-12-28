package com.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "<blank>") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return String.valueOf(ThreadLocalRandom.current().nextInt());
    }
}
