package com.example.__csrf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AccountService accountService;

    private Map<String,String> userData = new HashMap<>();

    @GetMapping("/public")
    public String publicMethod(){
        return "Public method";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Map<String,String> data){
        userData.put(data.get("username"),userData.get("password"));
        return "User saved in memory";
    }

    @GetMapping("/bal")
    public String getBal(){
        return accountService.addBal();
    }


    @GetMapping("/close")
    public String close(){
        return accountService.closeBal();
    }


}
