package sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Service1Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:{{service1.port}}/service1").routeId("service1").streamCaching()
            .log("Service1 request: ${body}")
            .to("direct:getResponse")
            .log("Service1 response: ${body}");
    }

}
