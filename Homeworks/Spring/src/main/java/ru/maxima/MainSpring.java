package ru.maxima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
      PasswordValidator passwordValidator =  applicationContext.getBean("passwordValidatorByCharacters", PasswordValidator.class);
      SignUpDataValidator validator = applicationContext.getBean(SignUpDataValidator.class);
    }
}
