package com.khush.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
         hello ob= (hello) context.getBean("hellobean");
        System.out.println(ob.getMessage());
    }

}
