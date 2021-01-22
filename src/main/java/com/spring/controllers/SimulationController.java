package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimulationController {

    @RequestMapping
    public String simulate() {
        return "field";
    }
}
