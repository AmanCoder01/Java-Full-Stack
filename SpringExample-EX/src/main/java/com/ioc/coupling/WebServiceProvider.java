package com.ioc.coupling;

public class WebServiceProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "Service provider";
    }
}
