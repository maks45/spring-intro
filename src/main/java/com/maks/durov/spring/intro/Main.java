package com.maks.durov.spring.intro;

import com.maks.durov.spring.intro.config.AppConfig;
import com.maks.durov.spring.intro.model.User;
import com.maks.durov.spring.intro.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User userJonny = new User();
        userJonny.setName("Jonny");
        userService.add(userJonny);
        User userValera = new User();
        userValera.setName("Valera");
        userService.add(userValera);
        userService.listUsers().forEach(System.out::println);
    }
}
