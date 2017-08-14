package sample.camel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service1")
public class Service1ConfigBean {

    private static final String GREETING = "GREETING";
    
    private String greeting;

    public Service1ConfigBean() {
    }

    public String getGreeting() {
        if (System.getenv(GREETING) != null && !System.getenv(GREETING).isEmpty())
            return System.getenv(GREETING);
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
