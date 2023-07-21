package com.example.guestbook;

import com.example.guestbook.domain.Address;
import com.example.guestbook.domain.Guest;
import com.example.guestbook.domain.Service.GuestService;
import com.sun.jndi.toolkit.url.GenericURLContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class GuestbookApplication {

    public static void main(String[] args) {
   //   new AnnotationConfigApplicationContext("com.example.guestbook");

      ApplicationContext applicationContext= SpringApplication.run(GuestbookApplication.class);
        GuestService guestService = applicationContext.getBean("guestService", GuestService.class);
      Guest guest= Guest.builder()
              .id(101)
              .firstname("Khushwinder")
              .lastname("Tuli")
              .phone("45475484")
              .address(Address.builder()
                      .city("Missi")
                      .postalCode("L5BU6S").build())
              .build();
       guestService.createGuest(guest);
        System.out.println(guestService.getGuest());
    }

}
