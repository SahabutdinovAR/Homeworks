package ru.maxima;

public class Main {

    public static void main(String[] args) {
	    Security security = Security.getInstance();
	    security.signUp("t1@gmail.com", "qwerty007");
	    security.signUp("t2@gmail.com", "qwerty008");
	    security.signUp("t3@gmail.com", "qwerty009");

        System.out.println(security.checkUser("t2@gmail.com", "qwerty008"));
        System.out.println(security.checkUser("t4@gmail.com", "qwerty010"));

        Security security1 = Security.getInstance();
        security1.signUp("fake@gmail.com", "fake");
        security1.signUp("fake1@gmail.com", "fake");
        security1.signUp("fake2@gmail.com", "fake");
    }
}
