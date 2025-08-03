package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Motor motor = (Motor) context.getBean("motor");

        motor.doWork();

        context.close();

    }
}
