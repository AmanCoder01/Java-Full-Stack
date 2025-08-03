package com.example.__Message_Service_Demo;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService{

    @Override
    public String getMessage() {
        return "Email: you have got a message";
    }
}
