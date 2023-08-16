package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FirstController {

    @GetMapping("/another")
    @ResponseBody
    public String returnAnother() {
        return "Hello Codeup!";
    }


    @GetMapping("/greeting/{greeting}")
    @ResponseBody
    public String returnGreeting(@PathVariable String greeting) {
        return "The greeting is " + greeting;
    }

    @GetMapping("/namegreeting/{firstName}/{lastName}")
    @ResponseBody
    public String returnNameGreeting(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hello, " + firstName + " " + lastName;
    }

}
