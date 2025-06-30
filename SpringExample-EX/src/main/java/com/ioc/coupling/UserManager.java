package com.ioc.coupling;


import com.loose.coupling.UserDataProvider;

public class UserManager {

    private com.loose.coupling.UserDataProvider userDataProvider;

    public UserManager(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    public String getUserInfo(){
        return userDataProvider.getUserDetails();
    }
}
