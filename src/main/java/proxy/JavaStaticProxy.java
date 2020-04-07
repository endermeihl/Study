package proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaStaticProxy implements Develop {

    Develop develop;

    JavaStaticProxy(Develop develop) {
        this.develop = develop;
    }

    @Override
    public void code() {
        log.info("Zack is playing for the code.");
        this.develop.code();
        log.info("Zack finished code.");
    }

    @Override
    public void deBug() {
        log.info("Zack's have no bug!No need to debug.");
    }
}
