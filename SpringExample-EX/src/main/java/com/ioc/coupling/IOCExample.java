package com.ioc.coupling;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationLooseCouplingExample.xml");

//        UserDataProvider databaseProvider = new UserDatabaseProvider();
//        UserManager userManagerWithDb = new UserManager(databaseProvider);
        UserManager userManagerWithDb = (UserManager) context.getBean("userManagerWithUserDataProvider");
        System.out.println(userManagerWithDb.getUserInfo());

//        UserDataProvider serviceProvider = new WebServiceProvider();
//        UserManager userManager = new UserManager(serviceProvider);
        UserManager userManagerWithWS = (UserManager) context.getBean("userManagerWithWebServiceProvider");
        System.out.println(userManagerWithWS.getUserInfo());
    }
}
