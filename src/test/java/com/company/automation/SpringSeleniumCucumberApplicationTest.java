package com.company.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class SpringSeleniumCucumberApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(SpringSeleniumCucumberApplicationTest.class, args);
    }
}
