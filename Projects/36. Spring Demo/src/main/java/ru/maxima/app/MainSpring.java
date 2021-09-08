package ru.maxima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maxima.SignUpService;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        SignUpService service = applicationContext.getBean(SignUpService.class);

        service.signUp("simple@simple.com", "ADSGSGSGSAGAGGAGA");
    }
}
