package com.loose.coupling;



public class LooseCouplingExample {
    public static void main(String[] args) {
        UserDataProvider databaseProvider = new UserDatabaseProvider();
        UserManager userManagerWithDb = new UserManager(databaseProvider);
        System.out.println(userManagerWithDb.getUserInfo());

        UserDataProvider serviceProvider = new WebServiceProvider();
        UserManager userManager = new UserManager(serviceProvider);
        System.out.println(userManager.getUserInfo());
    }
}
