package com.study;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws LifecycleException {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE); //EnableAutoConfiguration이 없어도 실행됨.
        springApplication.run(args);

    }

//    @Bean
//    public Holoman holoman() {
//        return new Holoman("new", 10);
//    }
}
