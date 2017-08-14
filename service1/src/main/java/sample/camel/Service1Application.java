package sample.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//CHECKSTYLE:OFF
/**
 * A Spring Boot application that runs Camel service 1
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Service1Application {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

}
//CHECKSTYLE:ON
