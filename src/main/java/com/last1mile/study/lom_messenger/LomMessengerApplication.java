package com.last1mile.study.lom_messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class LomMessengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LomMessengerApplication.class, args);
    }

}
