package com.study;

//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Web {

//    public static void main(String[] args) throws LifecycleException {
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//        tomcat.getConnector();
//
//        Context context = tomcat.addContext("", "/");
//
//        HttpServlet httpServlet = new HttpServlet() {
//            @Override
//            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                PrintWriter writer = resp.getWriter();
//                writer.println("hello !!");
//            }
//        };
//
//        String servletName = "helloServlet";
//        tomcat.addServlet("", servletName, httpServlet);
//        context.addServletMappingDecoded("/hello", servletName);
//
//        tomcat.start();
//        tomcat.getServer().await();
//    }
}
