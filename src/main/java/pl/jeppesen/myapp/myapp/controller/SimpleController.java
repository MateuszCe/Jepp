package pl.jeppesen.myapp.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


    @Controller
    @RequestMapping("/user")
    public class SimpleController {

        @GetMapping("/add")
        public String add() {
            return "addUser";
        }

        @GetMapping("/search")
        public String search() {
            return "searchUser";
        }
    }

