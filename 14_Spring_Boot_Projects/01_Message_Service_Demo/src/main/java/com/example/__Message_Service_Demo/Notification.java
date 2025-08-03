package com.example.__Message_Service_Demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {

    @Autowired
    private MessageService messageService;

    public Notification() {
    }

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(){
        System.out.println(messageService.getMessage());
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
