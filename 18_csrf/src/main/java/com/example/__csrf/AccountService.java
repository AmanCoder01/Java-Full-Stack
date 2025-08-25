package com.example.__csrf;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @PreAuthorize("hasRole('USER')")
    public String addBal(){
        return "Account balance 40000";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeBal(){
        return "Account closed";
    }
}
