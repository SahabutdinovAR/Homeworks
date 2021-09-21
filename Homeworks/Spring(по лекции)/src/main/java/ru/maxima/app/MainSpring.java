package ru.maxima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maxima.SignUpService;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        SignUpService service = applicationContext.getBean(SignUpService.class);

        service.signUp("simple@simple.com", "ADSGSGSGSAGAGGAGA");
    }
}


