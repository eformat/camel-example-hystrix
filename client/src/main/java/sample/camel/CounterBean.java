package sample.camel;

import org.springframework.stereotype.Component;

@Component("counterBean")
public class CounterBean {

    private int counter;

    public String someMethod(String body) {
        return "" + ++counter;
    }

}
