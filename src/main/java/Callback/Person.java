package Callback;

import base.BaseDemo;

import java.util.function.Function;

public class Person extends BaseDemo {

    public void greeting(Function<Person, Boolean> function) {
        boolean result = function.apply(this);
        logger.debug("+++++++++++++++aaaaa++++++++++++++++++++++++++");
        // do sth with result ……
    }
}