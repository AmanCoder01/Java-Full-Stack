package com.example.__SpringSecurity.controller;


import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/bank")
public class BankController {

    int bal = 100000;

    @GetMapping("/bal")
    public int getBalance(){
        return bal;
    }

    @GetMapping("/about")
    public String about(){
        return "About";
    }

    @PostMapping("/transfer")
    public String transfer(){
       return "Transferring money";
    }

    @GetMapping("/contactUs")
    public String contactUs(){
        return "Contact us 9872638763";
    }
}
