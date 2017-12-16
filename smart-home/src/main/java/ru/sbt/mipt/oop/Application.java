package ru.sbt.mipt.oop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EventObserver observer = context.getBean(EventObserver.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        observer.randomObserve(smartHome);

    }

}
