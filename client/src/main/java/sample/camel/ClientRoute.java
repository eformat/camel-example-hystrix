package sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ClientRoute extends RouteBuilder {

    @Override
    public void configure() {
        // you can configure the route rule with Java DSL here
        from("timer:trigger?period=1000").streamCaching()
            .bean("counterBean")
            .log(" Client request: ${body}")
            .hystrix()
                .id("service1")
                // see application.properties how hystrix is configured
                .to("http://{{service1.name}}:{{service1.port}}/service1")
            //.onFallback()
            // we use a fallback without network that provides a repsonse message immediately
            //    .transform().simple("Fallback ${body}")
            .onFallbackViaNetwork()
                // we use fallback via network where we call a 2nd service
                .to("http://{{service2.name}}:{{service2.port}}/service2")
            .end()
            .log("Client response: ${body}");
    }

}
