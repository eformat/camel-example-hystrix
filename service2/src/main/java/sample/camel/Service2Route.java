package sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Service2Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:{{service2.port}}/service2").routeId("service2").streamCaching()
                .log(" Service2 request: ${body}")
                .transform(simple("Service2-${body}"))
                .log("Service2 response: ${body}");
    }

}
