package com.tight.coupling;



public class UserManager {

    private UserDatabase userDatabase;

    public String getUserInfo(){
        return userDatabase.getUserDetails();
    }
}
